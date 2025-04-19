package com.ganache.icarus.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "signup")
@Data
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
    @Column(name = "gender", columnDefinition = "gender_enum") // Matches PostgreSQL ENUM type
    private Gender gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "alt_phone_number")
    private String altPhoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "profession", columnDefinition = "profession_enum")
    private Profession profession;

    @Enumerated(EnumType.STRING)
    @Column(name = "education", columnDefinition = "education_enum")
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
}
