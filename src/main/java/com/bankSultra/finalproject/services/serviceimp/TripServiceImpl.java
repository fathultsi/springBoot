package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.dto.TripDto;
import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Stop;
import com.bankSultra.finalproject.model.Trip;
import com.bankSultra.finalproject.repository.BusRepository;
import com.bankSultra.finalproject.repository.TripRepository;
import com.bankSultra.finalproject.services.BusService;
import com.bankSultra.finalproject.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.bankSultra.finalproject.mappers.DtoMapper.busToDto;
import static com.bankSultra.finalproject.mappers.DtoMapper.tripToDto;


@Service
@Transactional
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;



    @Override
    public List<TripDto> getAllTrip() {

        List<Trip> trips = tripRepository.findAll();
        return trips.stream()
                .map(a -> tripToDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public List<TripDto> findByStops(Long sourceStop, Long distStop) {

        List<Trip> trips = tripRepository.findBySourceStopIdAndDestStopId(sourceStop,distStop);
        return trips.stream()
                .map(a -> tripToDto(a))
                .collect(Collectors.toList());

    }


    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Boolean cekTripById(Long id) {
        return tripRepository.existsById(id);
    }
}
