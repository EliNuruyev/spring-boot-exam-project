package org.example.javacourse.service.inter;

import org.example.javacourse.dto.request.QuestionCreateRequestDTO;
import org.example.javacourse.dto.request.QuestionUpdateRequestDTO;
import org.example.javacourse.dto.response.QuestionResponseDTO;

import java.util.List;

public interface QuestionService {
    void create(QuestionCreateRequestDTO createRequestDTO);
    List<QuestionResponseDTO> getAllQuestions();
    void update(QuestionUpdateRequestDTO updateRequestDTO);
}
