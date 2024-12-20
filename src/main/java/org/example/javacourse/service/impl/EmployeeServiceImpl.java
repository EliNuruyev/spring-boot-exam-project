package org.example.javacourse.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.request.EmployeeCreateRequestDTO;
import org.example.javacourse.dto.response.EmployeeResponseDTO;
import org.example.javacourse.entity.Employee;
import org.example.javacourse.repository.EmployeeRepository;
import org.example.javacourse.service.inter.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;


    @Override
    public void create(EmployeeCreateRequestDTO employeeCreateRequestDTO) {
        Employee employee = Employee.builder()
                .firstName(employeeCreateRequestDTO.firstName())
                .lastName(employeeCreateRequestDTO.lastName())
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeResponseDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> new EmployeeResponseDTO(employee.getFirstName(), employee.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDTO findById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        Employee employee = optionalEmployee.get();

        return EmployeeResponseDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .build();
    }

    @Override
    public List<EmployeeResponseDTO> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName)
                .stream()
                .map(employee -> EmployeeResponseDTO.builder()
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .build())
                .collect(Collectors.toList());
    }
}
