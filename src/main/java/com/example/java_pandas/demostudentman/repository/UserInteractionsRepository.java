package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.UserInteractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInteractionsRepository extends JpaRepository<UserInteractions, Integer> {
    @Query(value = "SELECT * FROM user_interactions " +
            "WHERE user_id = :user_id AND news_id = :news_id", nativeQuery = true)
    List<Object[]> getInteractionType(@Param("user_id") Long userId, @Param("news_id") Long newsId);

    @Query(value = "SELECT news_id FROM user_interactions " +
            "WHERE interaction_type = 'LIKE' and user_id =:user_id",nativeQuery = true)
    List<Long> getUserInteractionsById(@Param("user_id") Long id);

}

