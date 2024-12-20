package org.example.javacourse.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.request.ResultRequestDTO;
import org.example.javacourse.service.inter.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResultController {
    ResultService resultService;

    @PostMapping
    public ResponseEntity<Double> getResult(@RequestParam String userName,
                                            @RequestParam String duration,
                                            @RequestBody List<ResultRequestDTO> resultRequestDTOS) {
        return ResponseEntity.ok(resultService.getResultPercentage(userName, duration, resultRequestDTOS));
    }
}
