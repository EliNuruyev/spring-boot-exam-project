package org.example.javacourse.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.response.LeadershipBoardResponseDTO;
import org.example.javacourse.service.inter.LeadershipBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leadership-board")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LeadershipBoardController {
    LeadershipBoardService leadershipBoardService;
    @GetMapping
    public ResponseEntity<List<LeadershipBoardResponseDTO>> getLeadershipBoard() {
        return ResponseEntity.ok(leadershipBoardService.getLeadershipBoard());
    }

}
