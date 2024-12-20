package org.example.javacourse.dto.response;

import lombok.Builder;

@Builder
public record EmployeeResponseDTO(String firstName, String lastName) {
}
