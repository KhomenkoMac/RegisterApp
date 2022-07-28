package com.example.register.Exceptions.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "passportDatas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PassportData {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "PassportDataId")
    private Integer passportDataId;

    @Column(name = "PassportNumber",
            nullable = false,
            unique = true)
    private String passportNumber;

    @Column(name = "IssuanceDate",
            nullable = false)
    private Date passportIssuanceDate;

    @Column(name = "TaxPayerCode",
            nullable = false,
            unique = true)
    private String taxPayerCode;

    @ManyToOne(cascade = ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "passport_series_id",
            referencedColumnName = "PassportSeriesId")
    private PassportSeries passportSeries;
}
