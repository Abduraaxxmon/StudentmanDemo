package com.example.java_pandas.demostudentman.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserViewedNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id",nullable = false)
    private New seenNews;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User seenUsers;

}
