package com.chrism.taskman.domain.dto;

public record ErrorResponse (

    int status,
    String message,
    String details

) {
    
}
