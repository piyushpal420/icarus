package com.ganache.icarus.Service;
import com.ganache.icarus.Entity.Signup;
import com.ganache.icarus.Repository.SignupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SignupService
{
    private final SignupRepository repository;
    private final EmailService emailService;

    public SignupService(SignupRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    //Saves the signup into the db, updates duplicate entry
    public Optional<Signup> saveSignup(Signup user)
    {
        boolean update = false;
        if(!checkSignup(user)) return Optional.empty();

        Optional<Signup> resp = repository.getSignupByEmail(user.getEmail());
        if(resp.isPresent())
        {
            update = true;
            Signup x = resp.get();
            user.setId(x.getId());
        }
        user.setName(user.getName().toLowerCase());
        user.setSubmitted_time(LocalDateTime.now());
        user = repository.save(user);
        if(!update) emailService.sendWelcomeMail(user.getEmail());
        return Optional.of(user);
    }


    //Checks the constraints of the DB
    private boolean checkSignup(Signup x)
    {
        if(x.getName()==null|| x.getAge()<0 || x.getAge()>120 || x.getDateOfBirth()==null||
        x.getGender()==null|| x.getPhoneNumber()==null|| x.getAltPhoneNumber()==null||
        x.getEmail()==null|| x.getAddress()==null|| x.getProfession()==null|| x.getEducation()==null) return false;

        if(x.getId() != null) x.setId(null);
        if(x.getSubmitted_time() != null) x.setSubmitted_time(null);
        return true;
    }


    //Checks the db and returns signup if found
    private Optional<Long> getIdByPhoneNumberOrAltPhoneNumber(String phoneNumber, String altPhoneNumber)
    {
        Optional<Signup> resp = repository.getSignupByPhoneNumberOrAltPhoneNumber(phoneNumber, altPhoneNumber);
        if(resp.isEmpty()){
            resp = repository.getSignupByPhoneNumberOrAltPhoneNumber(altPhoneNumber, phoneNumber);
        }
        if(resp.isEmpty()) return Optional.empty();
        return Optional.of(resp.get().getId());

    }


    //Searches the db for signup using email, returns Optional.empty() if not found
    public Optional<Signup> getSignupByEmail(String email)
    {
        return repository.getSignupByEmail(email);
    }


    //Delete Entry Using email
    public Optional<Signup> deleteSignupByEmail(String email)
    {
        Optional<Signup> x = getSignupByEmail(email);
        if(x.isEmpty()) return x;
        repository.delete(x.get());
        return x;
    }
}
