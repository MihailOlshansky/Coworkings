package com.team1.coworkings.exception

class EntityNotFoundException(entityName : String) :
    RuntimeException("Сущность $entityName не найдена") {}