package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagsRepository extends JpaRepository<Hashtag,Long> {
}
