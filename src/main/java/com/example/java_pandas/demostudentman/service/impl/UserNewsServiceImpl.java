    package com.example.java_pandas.demostudentman.service.impl;

    import com.example.java_pandas.demostudentman.dto.AttachmentDto;
    import com.example.java_pandas.demostudentman.dto.UserNewsDto;
    import com.example.java_pandas.demostudentman.entity.*;
    import com.example.java_pandas.demostudentman.mapper.ContactInfoMapper;
    import com.example.java_pandas.demostudentman.repository.*;
    import com.example.java_pandas.demostudentman.service.UserNewsService;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.util.*;
    import java.util.function.Predicate;
    @Slf4j
    @Service
    @RequiredArgsConstructor
    public class UserNewsServiceImpl implements UserNewsService {
        private final NewsRepository newsRepository;
        private final ContactInFoRepository contactInFoRepository;
        private final UserInteractionsRepository userInteractionsRepository;
        private final UserViewedNewsRepository viewedNewsRepository;
        private final AttachmentRepository attachmentRepository;
        private final ContactInfoMapper contactInfoMapper;
        @Override
        public Set<UserNewsDto> getUserNews(Long id){

            Set<UserNewsDto> recommendedNews = new HashSet<>();

            List<Object[]> news = newsRepository.findTopRecommendations(id);
            List<Long> longList = userInteractionsRepository.getUserInteractionsById(id);

//            List<UserInteractions> listLikedNewsIds = userInteractionsRepository.getUserInteractionsIdByUserId(id);

            for (Object[] obj : news) {
                Long newsId = (Long) obj[0];
                UserNewsDto newsDto = new UserNewsDto();
                New newfR = newsRepository.getReferenceById(newsId);
                newsDto.setId(newsId);
                newsDto.setTitle((String) obj[1]);
                newsDto.setContent((String) obj[2]);
                newsDto.setPoint(((Number)obj[3]).longValue());
                newsDto.setDescription(newfR.getDescription());

                for (Long son: longList){
                        newsDto.setIsliked(son== newsId);
                }
                if(!newfR.getType().equals("NEW")){
                    newsDto
                            .setContactInfoResponseDto
                                    (contactInfoMapper
                                            .toDto(contactInFoRepository.findByNewsId(newsId)));
                }else {
                    newsDto.setContactInfoResponseDto(null);
                }
                Set<AttachmentDto> attachmentDto= new HashSet<>();
                Set<Attachment> attachment = attachmentRepository.findAllByNewsAttachment(newsId);
                for (Attachment attach : attachment) {

                    String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/attachment/get-attachment")
                            .queryParam("id",attach.getId())
                            .toUriString();

                    AttachmentDto dto = AttachmentDto.builder()
                            .contentType(attach.getContentType())
                            .fileName(attach.getFilePath())
                            .fileSize(attach.getSize())
                            .uri(uri)
                            .filePath(attach.getFilePath())
                            .build();

                    attachmentDto.add(dto);
                }

                newsDto.setAttachmentDto(attachmentDto);
                recommendedNews.add(newsDto);
            }
            log.info("recommendedNews size: " + recommendedNews.size());
            return recommendedNews;
        }
    }
