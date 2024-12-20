package org.example.javacourse.dto.response;

import lombok.Builder;
import org.example.javacourse.enums.QuestionType;

import java.util.List;

@Builder
public record QuestionResponseDTO(String description, QuestionType questionType, List<AnswerResponseDTO> answers) {
}
