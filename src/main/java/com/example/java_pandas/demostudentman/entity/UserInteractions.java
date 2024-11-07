package com.example.java_pandas.demostudentman.entity;

import com.example.java_pandas.demostudentman.status.InteractionType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_interactions")
public class UserInteractions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User userLike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="news_id",nullable = false)
    private New interactedNews;

    @Column(nullable = false,name = "interaction_type")
    @Enumerated(EnumType.STRING)
    private InteractionType interactionType;

    @Column(nullable = false,name ="interaction_date")
    private Date interactionDate;




}
