package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Stop;
import com.bankSultra.finalproject.repository.BusRepository;
import com.bankSultra.finalproject.repository.StopRepository;
import com.bankSultra.finalproject.services.BusService;
import com.bankSultra.finalproject.services.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class StopServiceImpl implements StopService {

    @Autowired
    private StopRepository stopRepository;



    @Override
    public List<Stop> getAllStop() {
        return stopRepository.findAll();
    }

    @Override
    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }

    @Override
    public Boolean cekStopById(Long id) {
        return stopRepository.existsById(id);
    }
}
