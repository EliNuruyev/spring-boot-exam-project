package org.example.javacourse.error;

import lombok.Builder;

@Builder
public record ErrorResponse(Integer statusCode, String message) {

}