package com.example.java_pandas.demostudentman.entity;

import com.example.java_pandas.demostudentman.status.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@Table(name = "_users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hashtags_users",
            joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<Hashtag> hashtags;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<New> news;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "userLike",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserInteractions> userInteractions;

    @OneToMany(mappedBy = "seenUsers",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserViewedNews> userViewedNews;



    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}

