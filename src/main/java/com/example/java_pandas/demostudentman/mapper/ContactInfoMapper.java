package com.example.java_pandas.demostudentman.mapper;

import com.example.java_pandas.demostudentman.dto.ContactInfoResponseDto;
import com.example.java_pandas.demostudentman.entity.ContactInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactInfoMapper extends BaseEntityMap<ContactInfoResponseDto, ContactInfo> {

}
