package com.socialfitness.socialfitness.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkOutGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String caption;
    private double distanceRun;
    private int pushupsCompleted;
    private double weightLifted;
    @ManyToOne
    private User user;
    private LocalDateTime createdAt;
    @ManyToMany
    private List<User> liked = new ArrayList<>();
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

}
