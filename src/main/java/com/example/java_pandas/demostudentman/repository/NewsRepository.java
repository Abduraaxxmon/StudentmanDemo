package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<New,Long> {

}
