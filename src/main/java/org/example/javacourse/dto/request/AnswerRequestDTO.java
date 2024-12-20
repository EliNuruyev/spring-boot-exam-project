package org.example.javacourse.dto.request;

import lombok.Builder;

@Builder
public record AnswerRequestDTO(String description, Boolean isCorrect) {
}
