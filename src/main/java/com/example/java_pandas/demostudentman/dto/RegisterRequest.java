package com.example.java_pandas.demostudentman.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String email;
    private String password;

}
