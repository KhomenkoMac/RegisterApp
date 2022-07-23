package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "juridical_persons")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JuridicalPerson {

    @Id
    private Integer id;

    @Column(unique = true)
    private String EnterpriseName;

    @Column(unique = true)
    private String edrpou;

    @ManyToOne
    @JoinColumn(
            name = "activity_kind_id",
            referencedColumnName = "activityKindId",
            nullable = false)
    private ActivityKind activityKind;

    @ManyToOne
    @JoinColumn(
            name = "ownership_type_id",
            referencedColumnName = "ownershipTypeId",
            nullable = false)
    private OwnershipType ownershipType;

    private Double capitalPart;

    private String proceedingName;

    @Embedded
    private Place place;
}
