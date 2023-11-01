package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.dto.TripDto;
import com.bankSultra.finalproject.model.Agency;
import com.bankSultra.finalproject.model.Trip;

import java.util.List;


public interface TripService {

    List<TripDto> getAllTrip();

    List<TripDto> findByStops(Long sourceStop, Long distStop);

    Trip createTrip(Trip trip);

    Boolean cekTripById(Long id);
}
