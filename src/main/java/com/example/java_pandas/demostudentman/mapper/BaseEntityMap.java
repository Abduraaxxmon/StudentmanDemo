package com.example.java_pandas.demostudentman.mapper;

import java.util.List;

public interface BaseEntityMap<D,E> {
    D toEntity(E entity);
    E toDto(D dto);
    List<D> toDtoList(List<E> dtoList);
    List<E> toEntityList(List<D> dtoList);
}
