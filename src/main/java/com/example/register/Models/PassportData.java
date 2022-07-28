package com.example.register.Models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PassportData {
    @Column(name = "PassportNumber",
            nullable = false,
            unique = true)
    private String passportNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
