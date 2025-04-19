package com.ganache.icarus.Controller;

import com.ganache.icarus.Entity.Signup;
import com.ganache.icarus.Service.SignupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SignupController
{
    private final SignupService service;

    public SignupController(SignupService service) {
        this.service = service;
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck()
    {
        return new ResponseEntity<>("Signup Controller Works!!!!!", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSignup(@RequestBody Signup signup)
    {
        Optional<Signup> response = service.saveSignup(signup);
        if(response.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
    }
}
