package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ownership_types")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OwnershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ownershipTypeId;

    @Column(unique = true)
    private String name;
}
