package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<New, Long> {

    @Query(value = " " +
            "(SELECT n.id AS news_id, n.title, n.content, n.point " +
            " FROM new n " +
            " LEFT JOIN hashtag_news nh ON n.id = nh.news_id " +
            " LEFT JOIN hashtags_users uh ON nh.hashtag_id = uh.hashtag_id AND uh.user_id = :user_id " +
            " WHERE NOT EXISTS ( " +
            "     SELECT 1 FROM user_viewed_news uvn WHERE uvn.user_id = :user_id AND uvn.news_id = n.id " +
            " ) " +
            " GROUP BY n.id " +
            " ORDER BY COUNT(uh.hashtag_id) DESC, n.point DESC " +
            " LIMIT 40) " +
            " UNION ALL " +
            " (SELECT n.id AS news_id, n.title, n.content, n.point " +
            " FROM new n " +
            " LEFT JOIN hashtag_news nh ON n.id = nh.news_id " +
            " LEFT JOIN user_interactions ui ON ui.news_id = n.id AND ui.user_id = :user_id " +
            " WHERE NOT EXISTS ( " +
            "     SELECT 1 FROM user_viewed_news uvn WHERE uvn.user_id = :user_id AND uvn.news_id = n.id " +
            " ) " +
            " GROUP BY n.id " +
            " ORDER BY COUNT(ui.news_id) DESC, n.point DESC " +
            " LIMIT 40) " +
            " UNION ALL " +
            " (SELECT n.id AS news_id, n.title, n.content, n.point " +
            " FROM new n " +
            " WHERE NOT EXISTS ( " +
            "     SELECT 1 FROM user_viewed_news uvn WHERE uvn.user_id = :user_id AND uvn.news_id = n.id " +
            " ) " +
            " ORDER BY n.point DESC " +
            " LIMIT 20);", nativeQuery = true)
    List<Object[]> findTopRecommendations(@Param("user_id") Long userId);
}