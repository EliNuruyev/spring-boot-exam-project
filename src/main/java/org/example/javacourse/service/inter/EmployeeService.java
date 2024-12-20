package org.example.javacourse.service.inter;

import org.example.javacourse.dto.request.EmployeeCreateRequestDTO;
import org.example.javacourse.dto.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    void create(EmployeeCreateRequestDTO employeeCreateRequestDTO);

    List<EmployeeResponseDTO> findAll();

    EmployeeResponseDTO findById(Long id);

    List<EmployeeResponseDTO> findByFirstName(String firstName);
}
