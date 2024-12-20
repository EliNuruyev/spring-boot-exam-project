package org.example.javacourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.javacourse.enums.QuestionType;
import org.example.javacourse.util.CoreEntity;

import java.util.List;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@SuperBuilder
public class Question extends CoreEntity {
    @Column(name = "description", nullable = false)
    String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", nullable = false)
    QuestionType questionType;

    @OneToMany(mappedBy = "question")
    List<Answer> answers;
}
