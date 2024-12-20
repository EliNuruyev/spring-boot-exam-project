package org.example.javacourse.dto.response;

import lombok.Builder;

@Builder
public record LeadershipBoardResponseDTO(Long id, Double score, String name, String surname,Integer index) {
}
