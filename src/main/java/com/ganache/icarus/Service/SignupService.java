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

    public SignupService(SignupRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public Optional<Signup> saveSignup(Signup user)
    {
        if(!checkSignup(user)) return Optional.empty();
        user.setSubmitted_time(LocalDateTime.now());
        user = repository.save(user);
        return Optional.of(user);
    }
    private boolean checkSignup(Signup x)
    {
//        if(x.getName() == null || x.getAddress() == null || x.getPhoneNumber() == null) return false;
//        if(x.getId()!=null) x.setId(null);
//        if (x.getSubmitted_time()!=null) x.setSubmitted_time(null);
        if(x.getId() != null) x.setId(null);
        if(x.getSubmitted_time() != null) x.setSubmitted_time(null);
        return true;
    }
}
