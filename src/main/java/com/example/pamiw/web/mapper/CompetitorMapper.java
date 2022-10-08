package com.example.pamiw.web.mapper;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.web.dto.CompetitorReqDto;
import com.example.pamiw.web.dto.CompetitorRespDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitorMapper{
    Competitor mapCompetitorReqDtoToCompetitor(CompetitorReqDto dto);
    CompetitorRespDto mapCompetitorToCompetitorRespDto(Competitor competitor);
}
