package com.dsc.procv.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private User user;


    private String schoolName;
    private String department;
    private String degree;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean ongoing;
}