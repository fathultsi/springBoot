package com.bankSultra.finalproject.controller;

import com.bankSultra.finalproject.dto.AgencyDto;
import com.bankSultra.finalproject.exceptions.ResourceNotFoundException;
import com.bankSultra.finalproject.model.*;
import com.bankSultra.finalproject.services.*;
import io.swagger.annotations.ApiParam;
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
//@Api(value = "Bus Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/agency")
@Validated
public class AgencyController {

    @Autowired
    AgencyService agencyService;

//    @ApiOperation(value = "", response = Iterable.class)
    @PreAuthorize("hasRole('END')")
    @GetMapping(value = "/getAllagency", produces = {MediaType.APPLICATION_JSON_VALUE})
    List<AgencyDto> getAll() {
        return agencyService.getAllagency();
    }

//    @ApiOperation(value = "View a list of available agency", response = Iterable.class)
    @PreAuthorize("hasRole('END')")
    @PostMapping(value ="/createAgency", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createAgency(@RequestBody Agency agency){

        return new ResponseEntity<>(agencyService.createAgency(agency), HttpStatus.CREATED);
    }

//    @ApiOperation(value = "Delete agency by ID")
    @PreAuthorize("hasRole('END')")
    @DeleteMapping(value = "/deleteAgency")
    ResponseEntity<String> deleteAgency(@ApiParam(value = "Job ID") @PathParam("id")  int id) {
        Agency agency = agencyService.findById( (long)id)
                .orElseThrow(() -> new ResourceNotFoundException("agency Not Found with ID :" + id));

        agencyService.delete(agency.getId());
        return ResponseEntity.ok().body("ADMIN deleted with success!");

    }


}
