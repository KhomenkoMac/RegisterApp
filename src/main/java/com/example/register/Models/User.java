package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Patronymic", nullable = false)
    private String patronymic;

    @Column(name = "Birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "RoleId"
    )
    private Role role;

    @OneToOne(cascade = CascadeType.ALL,
              fetch = FetchType.EAGER)
    @JoinColumn(
            name = "passport_data_id",
            referencedColumnName = "PassportDataId")
    private PassportData passportData;

    @Embedded
    private Place place;
}
