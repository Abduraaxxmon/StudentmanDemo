package com.example.java_pandas.demostudentman.mapper;

import com.example.java_pandas.demostudentman.dto.UserRegisterDto;
import com.example.java_pandas.demostudentman.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseEntityMap<UserRegisterDto, User> {
}
