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
@Table(name = "leadership_board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@SuperBuilder
public class LeadershipBoard extends CoreEntity {
    @Column(name = "score")
    Double score;

    @Column(name = "duration")
    String duration;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

}
