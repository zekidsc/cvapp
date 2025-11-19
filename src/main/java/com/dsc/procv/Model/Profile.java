package com.dsc.procv.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    private String firstName;
    private String lastName;
    private String title;


    @Column(length = 4000)
    private String summary;


    private String phone;
    private String email;
    private String address;
    private String website;
    private String linkedin;
    private String github;
    private String photoUrl;
}
