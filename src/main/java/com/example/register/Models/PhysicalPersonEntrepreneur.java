package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "physical_person_entrepreneurs")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhysicalPersonEntrepreneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Patronymic", nullable = false)
    private String patronymic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "ProceedingName", nullable = false)
    private String proceedingName;

    @Embedded
    private PassportData passportData;

    @Embedded
    private Place place;
}
