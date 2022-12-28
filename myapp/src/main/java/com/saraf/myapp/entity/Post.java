package com.saraf.myapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")

// generating getters and setters using lombok

@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long postId;

    @Column(name = "post_photo")
    @NotNull
    private String postPhoto;

    @Column(name = "post_description")
    @NotNull
    private String postDescription;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User user;
}
