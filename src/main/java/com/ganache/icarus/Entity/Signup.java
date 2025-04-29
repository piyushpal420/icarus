package com.ganache.icarus.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "signup")
@Data
@Builder
@AllArgsConstructor
public class Signup
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "phone_number")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String phoneNumber;

    @Column(name = "alt_phone_number")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    private String altPhoneNumber;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "profession")
    private Profession profession;

    @Enumerated(EnumType.STRING)
    @Column(name = "education")
    private Education education;
    @Column(name = "past_association")
    private String past_association;
    @Column(name = "submitted_time")
    private LocalDateTime submitted_time;
    @Column(name = "dharmika_classes")
    private boolean dharmikaClasses;
    @Column(name = "financial_assistance")
    private boolean financialAssistance;
    @Column(name = "online_volunteer")
    private boolean onlineVolunteer;
    @Column(name = "ground_support")
    private boolean groundSupport;

    public Signup() {

    }
}
