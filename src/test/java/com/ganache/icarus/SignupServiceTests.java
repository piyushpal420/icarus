package com.ganache.icarus;

import com.ganache.icarus.Entity.Signup;
import com.ganache.icarus.Repository.SignupRepository;
import com.ganache.icarus.Service.SignupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SignupServiceTests {

    @InjectMocks
    private SignupService service;

    @Mock
    private SignupRepository repo;

    @Test
    public void getSignupByEmailTest()
    {
        when(repo.getSignupByEmail("piyushpal.recruitment@gmail.com"))
                .thenReturn(Optional.of(Signup.builder().id(8L).build()));

        Optional<Signup> x = service.getSignupByEmail("piyushpal.recruitment@gmail.com");
        Assertions.assertEquals(x.get().getId(), 8L);
    }
}

