package com.example.register.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_records")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LogRecord {
    @Id
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date operationOccurredAt;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
