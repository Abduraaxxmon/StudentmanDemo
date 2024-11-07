package com.example.java_pandas.demostudentman.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactInfoResponseDto {

    private String phoneNumber;
    private String startDate;
    private String endDate;
    private String location;
    private String webside;
}
