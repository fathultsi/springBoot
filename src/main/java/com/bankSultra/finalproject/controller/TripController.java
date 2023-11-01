package com.bankSultra.finalproject.controller;

import com.bankSultra.finalproject.dto.TripDto;
import com.bankSultra.finalproject.model.*;
import com.bankSultra.finalproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
//@Api(value = "Trip Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/trip")
@Validated
public class TripController {


    @Autowired
    TripService tripService;
    @Autowired
    StopService stopService;

//    @ApiOperation(value = "", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getAllTrip")
    List<TripDto> getAllTrip() {
        return tripService.getAllTrip();
    }

//    @ApiOperation(value = "", response = Iterable.class)

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/tripsbystops")
    List<TripDto> findByStops(@PathParam("sourceStop") Long sourceStop,
                           @PathParam("destStop") Long destStop) {
        return tripService.findByStops(sourceStop,destStop);
    }

//    @ApiOperation(value = "View a list of available Trip", response = Iterable.class)
    @PreAuthorize("hasRole('END')")
    @PostMapping(value ="/createTrip", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createTrip(@RequestBody Trip trip){

        Boolean cekStopById = stopService.cekStopById(trip.getDestStop().getId());

        if (!cekStopById){
            return ResponseEntity.badRequest().body("tidak ditemukan Stopid dengan id : "+ trip.getDestStop().getId());
        }

        Boolean cekStopById2 = stopService.cekStopById(trip.getSourceStop().getId());

        if (!cekStopById2){
            return ResponseEntity.badRequest().body("tidak ditemukan Stopid dengan id : "+ trip.getSourceStop().getId());
        }


        return new ResponseEntity<>(tripService.createTrip(trip), HttpStatus.CREATED);
    }


}
