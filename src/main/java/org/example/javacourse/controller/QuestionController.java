package org.example.javacourse.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.request.QuestionCreateRequestDTO;
import org.example.javacourse.dto.request.QuestionUpdateRequestDTO;
import org.example.javacourse.dto.response.QuestionResponseDTO;
import org.example.javacourse.service.inter.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuestionController {
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody QuestionCreateRequestDTO createRequestDTO) {
        questionService.create(createRequestDTO);
        return ResponseEntity.ok("SUCCESS");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody QuestionUpdateRequestDTO updateRequestDTO) {
        questionService.update(updateRequestDTO);
        return ResponseEntity.ok("SUCCESS");
    }
    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAll() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
}
