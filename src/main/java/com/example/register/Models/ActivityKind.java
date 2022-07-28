package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "activity_kinds")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActivityKind {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer activityKindId;

    @Column(unique = true)
    private String name;
}
