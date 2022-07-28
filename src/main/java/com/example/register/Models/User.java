package com.example.register.Models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "RoleId"
    )
    private Role role;

    @Embedded
    private PassportData passportData;
}
