package org.example.javacourse.repository;

import org.example.javacourse.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = """
            SELECT a.id FROM Answer a 
            WHERE a.question.id = :id 
            AND a.isCorrect = :isCorrect
            """)
    List<Long> findAllByQuestionId(@Param("id") Long questionId, Boolean isCorrect);
}
