package com.bankSultra.finalproject.dto;

import com.bankSultra.finalproject.model.TripSchedule;
import com.bankSultra.finalproject.model.UserList;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;


//@Getter
//@Setter
@Data
////@AllArgsConstructor
//@NoArgsConstructor
public class TicketMapDto {


    private Long id;


    private int seatNumber;
    private Boolean cancellable;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date journeyDate;


    private UserDto passenger;


  //  private TripSchedule tripSchedule;

}
