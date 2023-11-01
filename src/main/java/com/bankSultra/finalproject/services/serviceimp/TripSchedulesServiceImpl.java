package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.dto.TripScheduleDto;
import com.bankSultra.finalproject.model.TripSchedule;
import com.bankSultra.finalproject.repository.TicketRepository;
import com.bankSultra.finalproject.repository.TripSchedulesRepository;
import com.bankSultra.finalproject.services.TripSchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.bankSultra.finalproject.mappers.DtoMapper.agencyDtoMap;
import static com.bankSultra.finalproject.mappers.DtoMapper.tripScheduleToDto;


@Service
@Transactional
public class TripSchedulesServiceImpl implements TripSchedulesService {

    @Autowired
    private TripSchedulesRepository tripSchedulesRepository;


    @Override
    public List<TripSchedule> getAllTripSchedule() {
        return tripSchedulesRepository.findAll();
    }

    @Override
    public Boolean cekTripScedule(Long id) {
        return tripSchedulesRepository.existsById(id);
    }

    @Override
    public List<TripScheduleDto> findByDate(Date tripDate) {

        List<TripSchedule> tripSchedules= tripSchedulesRepository.findByTripDate(tripDate);
        return tripSchedules.stream()
                .map(a -> tripScheduleToDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public TripSchedule createTripSchedules(TripSchedule tripSchedule) {
        return tripSchedulesRepository.save(tripSchedule);
    }



}
