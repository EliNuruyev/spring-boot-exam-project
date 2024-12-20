package org.example.javacourse.repository;

import org.example.javacourse.entity.LeadershipBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadershipBoardRepository extends JpaRepository<LeadershipBoard, Long> {
    @Query(" SELECT l1 " +
            " FROM LeadershipBoard l1" +
            " where l1.insertDate =" +
                " (SELECT max(l2.insertDate)" +
                " FROM LeadershipBoard l2" +
                " where l1.employee.id = l2.employee.id " +
                " AND l2.score = (" +
                   " SELECT max (l3.score)" +
                   " FROM LeadershipBoard l3 " +
                   " where l1.employee.id = l3.employee.id))" +
                   " order by l1.insertDate desc limit 10")
    List<LeadershipBoard> findTop10User();
}
