package com.bankSultra.finalproject.controller;

import com.bankSultra.finalproject.dto.TicketSoldDTO;
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
@RequestMapping(value = "/api/v1/stop")
@Validated
public class StopController {


    @Autowired
    StopService stopService;


//    @ApiOperation(value = "", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/stops")
    List<Stop> getAllStop() {
        return stopService.getAllStop();
    }
//    @ApiOperation(value = "View a list of available Stop", response = Iterable.class)

    @PreAuthorize("hasRole('END') ")
    @PostMapping(value ="/createStop", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createStop(@RequestBody Stop stop){
        return new ResponseEntity<>(stopService.createStop(stop), HttpStatus.CREATED);
    }


}
