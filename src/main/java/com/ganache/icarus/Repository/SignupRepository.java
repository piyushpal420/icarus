package com.ganache.icarus.Repository;
import com.ganache.icarus.Entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignupRepository extends JpaRepository<Signup, Long>
{
    Optional<Signup> getSignupByNameAndPhoneNumberOrAltPhoneNumber(String name, String phoneNumber, String altPhoneNumber);
    Optional<Signup> getSignupByNameAndAltPhoneNumberOrPhoneNumber(String name, String altPhoneNumber, String phoneNumber);
    Optional<Signup> getSignupByNameAndAltPhoneNumber(String name, String altPhoneNumber);
    Optional<Signup> getSignupByNameAndPhoneNumber(String name, String phoneNumber);
    Optional<Signup> getSignupByPhoneNumberOrAltPhoneNumber(String phoneNumber, String altPhoneNumber);
    Optional<Signup> getSignupByEmail(String email);
}
