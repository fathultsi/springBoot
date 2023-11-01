package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.dto.TripScheduleDto;
import com.bankSultra.finalproject.model.TripSchedule;

import java.sql.Date;
import java.util.List;


public interface TripSchedulesService {

    List<TripSchedule> getAllTripSchedule();
    Boolean cekTripScedule(Long id);

    List<TripScheduleDto> findByDate(Date tripDate);

    TripSchedule createTripSchedules(TripSchedule tripSchedule);


}
