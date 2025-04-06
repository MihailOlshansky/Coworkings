package com.team1.coworkings.exception

class LogicalException(message : String, cause: Throwable? = null) :
    RuntimeException(message, cause) {}