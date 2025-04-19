package com.ganache.avhaan.newahvaan.Controller;
/*
import com.ganache.avhaan.ahvaan.Entity.Feedback;
import com.ganache.avhaan.ahvaan.Service.FeedbackService;
import jakarta.validation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    private final FeedbackService service;

    public AdminController(FeedbackService service) {
        this.service = service;
    }

    @Getter@Setter@AllArgsConstructor@NoArgsConstructor
    public static class MyRequest
    {
        private Long id;
        private String name;
        private String phoneNumber;
    }

    @GetMapping("/AllFeedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks()
    {
        return new ResponseEntity<>(service.getAllFeedbacks(), HttpStatus.FOUND);
    }
    @GetMapping("/FeedbackById")
    public ResponseEntity<?> getFeedbackById(@RequestBody MyRequest request)
    {
        Optional<?> response = service.getFeedbackById(request.id);
        if(response.isEmpty()) return new ResponseEntity<>("Feedback with Id: "+request.id+" was not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>((Feedback)response.get(), HttpStatus.FOUND);
    }


    @DeleteMapping("/deleteFeedback")
    public ResponseEntity<?> deleteById(@RequestBody MyRequest request)
    {
        boolean response = service.deleteById(request.id);
        if(response) return new ResponseEntity<>(HttpStatus.ACCEPTED);
        else  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("health")
    public ResponseEntity<?> check()
    {
        return new ResponseEntity<>("ADMIN CONTROLLER WORKS!!!!", HttpStatus.OK);
    }


}
*/