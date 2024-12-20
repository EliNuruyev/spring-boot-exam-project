package org.example.javacourse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true)
@Getter
public enum QuestionType {
    MULTI_CHOICE("multiChoice"),
    SINGLE_CHOICE("singleChoice");

    String value;
}
