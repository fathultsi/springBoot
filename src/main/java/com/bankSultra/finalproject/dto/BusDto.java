package com.bankSultra.finalproject.dto;

import com.bankSultra.finalproject.model.Agency;
import com.bankSultra.finalproject.model.Trip;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


//@Getter
//@Setter
@Data
////@AllArgsConstructor
//@NoArgsConstructor
public class BusDto {


    private Long id;

    private String code;
    private int capacity;
    private String make;

    private AgencyDto agency;

//    private List<Trip> trips;
}
