package com.team1.coworkings.base

import java.util.stream.Collectors

interface BaseMapper<E : Any, Dto> {
    fun entityToDto(entity: E): Dto
    fun dtoToEntity(dto: Dto): E

    fun entityToDto(entities: Collection<E>): List<Dto> {
        return entities.stream()
            .map(this::entityToDto)
            .collect(Collectors.toList())
    }

    fun dtoToEntity(dtos: Collection<Dto>): List<E> {
        return dtos.stream()
            .map(this::dtoToEntity)
            .collect(Collectors.toList())
    }
}
