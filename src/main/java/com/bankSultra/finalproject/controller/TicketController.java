package com.bankSultra.finalproject.controller;

import com.bankSultra.finalproject.dto.TicketDTO;
import com.bankSultra.finalproject.dto.TicketMapDto;
import com.bankSultra.finalproject.model.*;
import com.bankSultra.finalproject.services.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Api(value = "Tikcet Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/ticket")
@Validated
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    TripSchedulesService tripSchedulesService;


    //ticket
//    @ApiOperation(value = "", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getAllTicket", produces = {MediaType.APPLICATION_JSON_VALUE})
    List<TicketMapDto> getAllTicket() {
        return ticketService.getAllTicket();
    }
//
//    @ApiOperation(value = "View a list of available ticket", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value ="/createTicket", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createTicket(@RequestBody TicketDTO ticketDTO){

        Boolean cekTripSchedule = tripSchedulesService.cekTripScedule(ticketDTO.getIdScedule());
        if (!cekTripSchedule){
            return ResponseEntity.badRequest().body("tidak ditemukan TripSchedule dengan id : "+ ticketDTO.getIdScedule());
        }


        return new ResponseEntity<>(ticketService.createTicket(ticketDTO), HttpStatus.CREATED);
    }

}
