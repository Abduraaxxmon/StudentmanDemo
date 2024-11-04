package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.UserViewedNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserViewedNewsRepository extends JpaRepository<UserViewedNews, Integer> {
}
