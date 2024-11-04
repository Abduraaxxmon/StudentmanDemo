package com.example.java_pandas.demostudentman.entity;

import com.example.java_pandas.demostudentman.status.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="hashtag_news",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<Hashtag> hashtags;

    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "newsAttachment",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Attachment> attachments;

    @OneToMany(mappedBy = "interactedNews",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserInteractions> userInteractions;

    @OneToMany(mappedBy = "seenNews",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserViewedNews> userViewedNews;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;

    @OneToOne(mappedBy = "news",cascade = CascadeType.ALL,orphanRemoval = true)
    private ContactInfo contactInfo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date uploaded_at;

    @Column(nullable = false)
    private Date edited_at;

    @Enumerated(EnumType.STRING)
    private Event type;

    @Column(nullable = false)
    private Long point;


}
