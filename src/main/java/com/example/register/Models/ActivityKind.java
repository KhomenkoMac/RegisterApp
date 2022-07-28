package com.example.register.Exceptions.Models;

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
    private Integer activityKindId;

    @Column(unique = true)
    private String Name;
}
