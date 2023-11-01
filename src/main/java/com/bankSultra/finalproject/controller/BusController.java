package com.bankSultra.finalproject.controller;

import com.bankSultra.finalproject.dto.BusDto;
import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Stop;
import com.bankSultra.finalproject.services.AgencyService;
import com.bankSultra.finalproject.services.BusService;
import com.bankSultra.finalproject.services.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Api(value = "Bus Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/bus")
@Validated
public class BusController {


    @Autowired
    BusService busService;
    @Autowired
    AgencyService agencyService;


//    @ApiOperation(value = "", response = Iterable.class)
    @PreAuthorize("hasRole('END')")
    @GetMapping(value = "/getAllBus")
    List<BusDto> getAllBus() {
        return busService.getAllBus();
    }
//    @ApiOperation(value = "View a list of available Stop", response = Iterable.class)

    @PreAuthorize("hasRole('END')")
    @PostMapping(value ="/createBus", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createBus(@RequestBody Bus bus){

        Boolean cekIdAgency = agencyService.cekAgencyById(bus.getAgency().getId());

        if (!cekIdAgency){
            return ResponseEntity.badRequest().body("tidak ditemukan agency id dengan id : "+ bus.getAgency().getId());
        }

        return new ResponseEntity<>(busService.createBus(bus), HttpStatus.CREATED);
    }


}
