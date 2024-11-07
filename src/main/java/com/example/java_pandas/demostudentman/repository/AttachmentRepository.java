package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
    @Query(value = "SELECT a.id, a.news_id, a.file_path, a.filename, a.content_type, a.extension, a.size " +
            "FROM attachment a " +
            "INNER JOIN new n ON a.news_id = n.id " +
            "WHERE n.id = :newsId", nativeQuery = true)
    Set<Attachment> findAllByNewsAttachment(@Param("newsId") Long newsId);
}
