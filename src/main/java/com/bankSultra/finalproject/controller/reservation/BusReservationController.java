package com.bankSultra.finalproject.controller.reservation;

import com.bankSultra.finalproject.dto.TicketSoldDTO;
import com.bankSultra.finalproject.dto.TripDto;
import com.bankSultra.finalproject.dto.TripScheduleDto;
import com.bankSultra.finalproject.model.*;
import com.bankSultra.finalproject.services.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

@RestController
@Api(value = "Bus Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/reservation")
@Validated
public class BusReservationController {


    @Autowired
    StopService stopService;

    @Autowired
    TripService tripService;
    @Autowired
    TripSchedulesService tripSchedulesService;

    @Autowired
    TicketService ticketService;



    @ApiOperation(value = "getaAllStops", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping(value = "/stops")
    List<Stop> getAllStop() {
        return stopService.getAllStop();
    }

    @ApiOperation(value = "getTripsByStops", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/tripsbystops")
    List<TripDto> getTripsByStops(@PathParam("sourceStop") Long sourceStop,
                           @PathParam("destStop") Long destStop) {
        return tripService.findByStops(sourceStop,destStop);
    }

    //    TripSchedule
    @ApiOperation(value = "getTripSchedule", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping(value = "/tripsSchedules")
    List<TripScheduleDto> findByDate(@PathParam("tripDate") Date tripDate) {
        return tripSchedulesService.findByDate(tripDate);
    }

    @ApiOperation(value = "bookticket", response = Iterable.class)
    @PostMapping(value ="/bookticket", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> insertMapTripTicket(@RequestBody TicketSoldDTO ticketSoldDTO,
                                                 @RequestHeader("Authorization") String authorizationHeader){
        Boolean cekIdTicket = ticketService.cekTickeById(ticketSoldDTO.getTicket_id());

        if (!cekIdTicket){
            return ResponseEntity.badRequest().body("tidak ditemukan id Ticket : "+ ticketSoldDTO.getTicket_id());
        }

        // Check if the Authorization header is present and starts with "Bearer "
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extract the token (excluding "Bearer ")
            String token = authorizationHeader.substring(7);

//            // Now you have the Bearer token in the 'token' variable, and you can use it as needed.
//        } else {
//            // The Authorization header is missing or not in the expected format
//            return ResponseEntity.badRequest().body("Invalid or missing Bearer token.");
//        }

       ticketService.insertMapTripTicket(ticketSoldDTO.getTicket_id(), token);
        //cekTickeById

        return ResponseEntity.ok().body("Berhasil Pesan Tiket, dengan tiket id : "+ticketSoldDTO.getTicket_id());
    }
//    insertMapTripTicket



}
