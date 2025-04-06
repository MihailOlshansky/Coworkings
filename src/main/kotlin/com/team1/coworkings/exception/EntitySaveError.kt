package com.team1.coworkings.exception

class EntitySaveError(entityClassName: String, cause: Throwable)
    : RuntimeException("Ошибка при сохранении $entityClassName", cause) {}