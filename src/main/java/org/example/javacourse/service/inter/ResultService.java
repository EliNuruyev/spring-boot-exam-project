package org.example.javacourse.service.inter;

import org.example.javacourse.dto.request.ResultRequestDTO;

import java.util.List;

public interface ResultService {
    Double getResultPercentage(String userName, String duration, List<ResultRequestDTO> resultRequestDTOS);
}