package org.example.javacourse.dto.response;

import lombok.Builder;

@Builder
public record AnswerResponseDTO(Long id, String description) {
}
