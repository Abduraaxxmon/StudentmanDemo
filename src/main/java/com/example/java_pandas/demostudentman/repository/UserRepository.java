package com.example.java_pandas.demostudentman.repository;


import com.example.java_pandas.demostudentman.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
