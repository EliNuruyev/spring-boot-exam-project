package org.example.javacourse.dto.request;

import org.example.javacourse.enums.QuestionType;

import java.util.List;

public record QuestionCreateRequestDTO(String description, QuestionType questionType, List<AnswerRequestDTO> answers) {

}
