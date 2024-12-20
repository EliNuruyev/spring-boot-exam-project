package org.example.javacourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.javacourse.util.CoreEntity;

@Entity
@Table(name = "answer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@SuperBuilder
public class Answer extends CoreEntity {
    @Column(name = "description")
    String description;

    @Column(name = "isCorrect")
    Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    Question question;

    @PrePersist
    private void preInsert() {
        if (isCorrect == null) {
            isCorrect = false;
        }
    }
}
