package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.dto.BusDto;
import com.bankSultra.finalproject.model.Agency;
import com.bankSultra.finalproject.model.Bus;

import java.util.List;


public interface BusService {

    List<BusDto> getAllBus();

    Bus createBus(Bus bus);

    Boolean cekBusById(Long id);
}
