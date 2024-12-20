package org.example.javacourse.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.request.ResultRequestDTO;
import org.example.javacourse.entity.Employee;
import org.example.javacourse.entity.LeadershipBoard;
import org.example.javacourse.entity.Question;
import org.example.javacourse.enums.QuestionType;
import org.example.javacourse.repository.AnswerRepository;
import org.example.javacourse.repository.LeadershipBoardRepository;
import org.example.javacourse.repository.QuestionRepository;
import org.example.javacourse.repository.UserRepository;
import org.example.javacourse.service.inter.ResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResultServiceImpl implements ResultService {
    AnswerRepository answerRepository;
    QuestionRepository questionRepository;
    LeadershipBoardRepository leadershipBoardRepository;
    UserRepository userRepository;

    @Override
    public Double getResultPercentage(String userName, String duration, List<ResultRequestDTO> resultRequestDTOS) {
        double result = 0.0;

        for (ResultRequestDTO resultRequestDTO : resultRequestDTOS) {
            Long questionId = resultRequestDTO.questionId();
            List<Long> correctAnswers = answerRepository.findAllByQuestionId(questionId, true);
            List<Long> userAnswers = resultRequestDTO.answers();

            Question question = questionRepository.findByIdAndStatus(resultRequestDTO.questionId(), "A").orElseThrow();

            if (question.getQuestionType().equals(QuestionType.MULTI_CHOICE)) {
                double point = 1.0 / correctAnswers.size();
                result += userAnswers.stream()
                        .filter(correctAnswers::contains)
                        .count() * point;
            } else {
                result += correctAnswers.equals(userAnswers) ? 1.0 : 0.0;
            }
        }

        double score = result / resultRequestDTOS.size() * 100;

        Employee user = userRepository.findByFirstName(userName);
        if(user.getQuizCount() == null){
            user.setQuizCount(0);
        }
        user.setQuizCount(user.getQuizCount() + 1);

        if (user == null || user.getId() == null) {
            throw new RuntimeException("User not found");
        }

        LeadershipBoard leadershipBoard = LeadershipBoard.builder()
                .score(score)
                .employee(user)
                .duration(duration)
                .build();
        leadershipBoardRepository.save(leadershipBoard);

        return score;
    }
}
