package com.example.java_pandas.demostudentman.repository;

import com.example.java_pandas.demostudentman.entity.Attachment;
import com.example.java_pandas.demostudentman.entity.New;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
    Attachment findByNewsAttachment(New newsAttachment);
}
