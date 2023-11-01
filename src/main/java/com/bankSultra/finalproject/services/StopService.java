package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Stop;

import java.util.List;


public interface StopService {

    List<Stop> getAllStop();

    Stop createStop(Stop stop);

    Boolean cekStopById(Long id);


}
