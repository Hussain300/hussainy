package com.saraf.myapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="users")

// using lombok dependency to generate getters and setters automatically
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @NonNull
    @Column(name="username")
    private String username;

    @NotBlank
    @NonNull
    @Column(name="password")
    private String password;

    @NotBlank
    @NonNull
    @Column(name = "role")
    private String role;
}
