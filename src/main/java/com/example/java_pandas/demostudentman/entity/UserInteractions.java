package com.example.java_pandas.demostudentman.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_interactions")
public class UserInteractions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userLike;

    @ManyToOne
    @JoinColumn(name="news_id",nullable = false)
    private New interactedNews;




}
