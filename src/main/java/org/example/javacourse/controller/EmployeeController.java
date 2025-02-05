package org.example.javacourse.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.request.EmployeeCreateRequestDTO;
import org.example.javacourse.dto.response.EmployeeResponseDTO;
import org.example.javacourse.service.inter.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {
    EmployeeService employeeService;


    @PostMapping
    public String create(@RequestBody EmployeeCreateRequestDTO employeeCreateRequestDTO
    ) {
        employeeService.create(employeeCreateRequestDTO);
        return "Success";
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeResponseDTO>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> findByFirstName(@RequestParam(value = "firstName", required = false) String firstName) {
        return ResponseEntity.ok(employeeService.findByFirstName(firstName));
    }
}
