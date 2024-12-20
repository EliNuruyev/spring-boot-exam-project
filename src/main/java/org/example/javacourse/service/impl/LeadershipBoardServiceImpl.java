package org.example.javacourse.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.javacourse.dto.response.LeadershipBoardResponseDTO;
import org.example.javacourse.repository.LeadershipBoardRepository;
import org.example.javacourse.service.inter.LeadershipBoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LeadershipBoardServiceImpl implements LeadershipBoardService {
    LeadershipBoardRepository leadershipBoardRepository;

    @Override
    public List<LeadershipBoardResponseDTO> getLeadershipBoard() {
        AtomicInteger i = new AtomicInteger(1);
        return   leadershipBoardRepository.findTop10User().stream().map(
               leadershipBoard -> LeadershipBoardResponseDTO.builder()
                         .id(leadershipBoard.getId())
                         .score(leadershipBoard.getScore())
                         .name(leadershipBoard.getEmployee().getFirstName())
                         .surname(leadershipBoard.getEmployee().getLastName())
                         .index(i.getAndIncrement())
                         .build()
         ).toList();

    }
}
