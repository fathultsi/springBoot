package com.bankSultra.finalproject.mappers;


import com.bankSultra.finalproject.dto.AgencyDto;
import com.bankSultra.finalproject.model.Agency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AgencyMapper {



    AgencyDto agencyToAgencyDto(Agency agency);

    List<AgencyDto> agencyToAgencyDto2(List<Agency> agency);
    Agency agencyDtoToAgency(AgencyDto agencyDto);

}
