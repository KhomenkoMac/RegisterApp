package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "passportSeries")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PassportSeries {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "PassportSeriesId")
    private Integer id;

    @Column(name = "SeriesName", unique = true, length = 2)
    private String name;

//    @OneToMany(cascade = CascadeType.REMOVE,
//            fetch = FetchType.LAZY)
//    private List<User> users;
}
