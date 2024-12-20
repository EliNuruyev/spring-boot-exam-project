package org.example.javacourse.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.request.AnswerRequestDTO;
import org.example.javacourse.dto.request.QuestionCreateRequestDTO;
import org.example.javacourse.dto.request.QuestionUpdateRequestDTO;
import org.example.javacourse.dto.response.AnswerResponseDTO;
import org.example.javacourse.dto.response.QuestionResponseDTO;
import org.example.javacourse.entity.Answer;
import org.example.javacourse.entity.Question;
import org.example.javacourse.exception.QuestionNotFoundException;
import org.example.javacourse.mapper.QuestionMapper;
import org.example.javacourse.repository.AnswerRepository;
import org.example.javacourse.repository.QuestionRepository;
import org.example.javacourse.service.inter.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
import static org.example.javacourse.error.ExceptionMessage.QUESTION_NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuestionServiceImpl implements QuestionService {
    AnswerRepository answerRepository;
    QuestionRepository questionRepository;
    QuestionMapper questionMapper;

    @Override
    public void create(QuestionCreateRequestDTO createRequestDTO) {
        Question question = questionRepository.save(
//                questionMapper.toEntity(createRequestDTO)
                Question.builder()
                        .questionType(createRequestDTO.questionType())
                        .description(createRequestDTO.description())
                        .build()
        );
        List<AnswerRequestDTO> answers = createRequestDTO.answers();
        for (AnswerRequestDTO answer : answers) {
            answerRepository.save(Answer.builder()
                    .question(question)
                    .isCorrect(answer.isCorrect())
                    .description(answer.description())
                    .build());
        }
    }

    @Override
    public List<QuestionResponseDTO> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(questionMapper::toDTO)
                .toList();
    }

    @Override
    public void update(QuestionUpdateRequestDTO updateRequestDTO) {
        Question question = questionRepository.findByIdAndStatus(updateRequestDTO.id(), "A")
                .stream()
                .findFirst()
                .orElseThrow(() -> new QuestionNotFoundException(
                                format(
                                        QUESTION_NOT_FOUND.getMessage(),
                                        updateRequestDTO.id()
                                )
                        )
                );
        question.setDescription(updateRequestDTO.description());
        questionRepository.save(question);
    }
}