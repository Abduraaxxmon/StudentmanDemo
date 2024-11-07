package com.example.java_pandas.demostudentman.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hashtag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "hashtags")
    private Set<New> hashtagNews;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "hashtags")
    private Set<User> hashtagUsers;

    @Column(nullable = false)
    private String hashtag;

}
