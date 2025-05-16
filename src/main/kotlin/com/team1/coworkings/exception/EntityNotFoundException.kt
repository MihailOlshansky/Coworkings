package com.team1.coworkings.exception
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class EntityNotFoundException(entityName : String) :
    RuntimeException("Сущность $entityName не найдена") {}