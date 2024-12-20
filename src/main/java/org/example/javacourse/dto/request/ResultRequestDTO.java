package org.example.javacourse.dto.request;

import java.util.List;

public record ResultRequestDTO(Long questionId, List<Long> answers) {

}