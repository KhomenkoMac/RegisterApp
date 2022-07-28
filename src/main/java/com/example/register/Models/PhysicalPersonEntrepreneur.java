package com.example.register.Exceptions.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Patronymic", nullable = false)
    private String patronymic;

    @Column(name = "Birthdate", nullable = false)
    private Date birthdate;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(
            name = "passport_data_id",
            referencedColumnName = "PassportDataId")
    private PassportData passportData;
}
