package com.example.java_pandas.demostudentman.dto;

import com.example.java_pandas.demostudentman.status.InteractionType;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserNewsDto {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Long point;
    private Set<AttachmentDto> attachmentDto;
    private ContactInfoResponseDto contactInfoResponseDto;
    private Boolean isliked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNewsDto news = (UserNewsDto) o;
        return Objects.equals(id, news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
