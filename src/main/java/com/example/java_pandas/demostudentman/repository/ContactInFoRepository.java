package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInFoRepository extends JpaRepository<ContactInfo,Long> {
}
