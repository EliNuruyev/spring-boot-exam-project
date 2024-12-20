package org.example.javacourse.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.javacourse.util.CoreEntity;

import java.util.List;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@SuperBuilder
public class Employee extends CoreEntity {
    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "quiz_count")
    Integer quizCount;

    @OneToMany(mappedBy = "employee")
    List<LeadershipBoard> leadershipBoards;
}
