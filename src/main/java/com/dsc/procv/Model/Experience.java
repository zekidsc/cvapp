package com.dsc.procv.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private User user;


    private String companyName;
    private String positionTitle;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean current;


    @Column(length = 4000)
    private String description;


    @ElementCollection
    private List<String> achievements;
}