package com.example.java_pandas.demostudentman.entity;

import com.example.java_pandas.demostudentman.status.Event;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class New implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name="hashtag_news",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<Hashtag> hashtags;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "news",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "newsAttachment",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Attachment> attachments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "interactedNews",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserInteractions> userInteractions;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "seenNews",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<UserViewedNews> userViewedNews;

    @ManyToOne(fetch = FetchType.LAZY)
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


    private Date edited_at;

    @Enumerated(EnumType.STRING)
    private Event type;

    @Column(nullable = false)
    private Long point;


}
