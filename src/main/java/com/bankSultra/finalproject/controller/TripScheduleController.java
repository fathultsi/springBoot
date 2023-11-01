package com.bankSultra.finalproject.controller;

import com.bankSultra.finalproject.dto.TicketSoldDTO;
import com.bankSultra.finalproject.dto.TripScheduleDto;
import com.bankSultra.finalproject.exceptions.ResourceNotFoundException;
import com.bankSultra.finalproject.model.*;
import com.bankSultra.finalproject.services.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

@RestController
//@Api(value = "Bus Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/tripschedule")
@Validated
public class TripScheduleController {

    @Autowired
    TripSchedulesService tripSchedulesService;
    @Autowired
    TripService tripService;


//    TripSchedule

//    @ApiOperation(value = "", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/tripsSchedules")
    List<TripScheduleDto> findByDate(@PathParam("tripDate") Date tripDate) {
        return tripSchedulesService.findByDate(tripDate);
    }

    @PreAuthorize("hasRole('ADMIN')")
//    @ApiOperation(value = "View a list of available TripSchedule", response = Iterable.class)
    @PostMapping(value ="/createTripSchedules", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createTripSchedules(@RequestBody TripSchedule tripSchedule){

        Boolean cekTripById = tripService.cekTripById(tripSchedule.getTripDetail().getId());

        if (!cekTripById){
            return ResponseEntity.badRequest().body("tidak ditemukan trip dengan id : "+ tripSchedule.getTripDetail().getId());
        }

        return new ResponseEntity<>(tripSchedulesService.createTripSchedules(tripSchedule), HttpStatus.CREATED);
//        return new ResponseEntity<>(cekTripById, HttpStatus.CREATED);
    }

}
