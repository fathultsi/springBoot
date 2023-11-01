package com.bankSultra.finalproject.dto;

import com.bankSultra.finalproject.model.Agency;
import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Stop;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;


//@Getter
//@Setter
@Data
////@AllArgsConstructor
//@NoArgsConstructor
public class TripDto {

    private Long id;
    private int fare;

    @JsonFormat(pattern = "hh:mm:ss")
    private Time journeyTime;

    private Stop sourceStop;


    private Stop destStop;


    private BusDto bus;

    private AgencyDto agency;

//    private List<Trip> trips;
}
