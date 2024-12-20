package org.example.javacourse.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    QUESTION_NOT_FOUND("Not found question with id: %s");

    private final String message;
}
