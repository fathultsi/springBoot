package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.dto.AgencyDto;
import com.bankSultra.finalproject.model.Agency;

import java.util.List;
import java.util.Optional;


public interface AgencyService {

    List<AgencyDto> getAllagency();

    Boolean cekAgencyById(Long id);
    Optional<Agency> findById(Long id);

    Agency createAgency(Agency agency);
    void delete(Long id);


}
