package com.example.java_pandas.demostudentman.mapper;

import com.example.java_pandas.demostudentman.dto.LoginRequest;
import com.example.java_pandas.demostudentman.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseEntityMap<LoginRequest, User> {
}
