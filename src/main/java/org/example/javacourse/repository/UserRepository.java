package org.example.javacourse.repository;

import org.example.javacourse.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstName(String firstName);
}