package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId", nullable = false)
    private Integer id;

    @Column(
            name = "Name",
            unique = true,
            nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE,
               fetch = FetchType.LAZY,
               mappedBy = "role")
    private Set<User> users;

}
