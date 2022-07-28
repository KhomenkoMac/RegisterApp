package com.example.register.Exceptions.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ownership_types")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OwnershipType {
    @Id
    private Integer ownershipTypeId;

    @Column(unique = true)
    private String Name;
}
