package org.example.javacourse.mapper;


import org.example.javacourse.dto.request.QuestionCreateRequestDTO;
import org.example.javacourse.dto.response.QuestionResponseDTO;
import org.example.javacourse.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
//    @Mapping(target = "type", source = "questionType")
    Question toEntity(QuestionCreateRequestDTO createRequestDTO);
//    @Mapping(target = "type", source = "questionType")
    QuestionResponseDTO toDTO(Question question);
}
