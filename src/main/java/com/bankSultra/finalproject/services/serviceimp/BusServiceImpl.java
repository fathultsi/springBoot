package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.dto.BusDto;
import com.bankSultra.finalproject.model.Agency;
import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.repository.BusRepository;
import com.bankSultra.finalproject.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.bankSultra.finalproject.mappers.DtoMapper.agencyDtoMap;
import static com.bankSultra.finalproject.mappers.DtoMapper.busToDto;


@Service
@Transactional
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;


    @Override
    public List<BusDto> getAllBus() {
        List<Bus> buses = busRepository.findAll();
        return buses.stream()
                .map(a -> busToDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Boolean cekBusById(Long id) {
        return busRepository.existsById(id);
    }
}
