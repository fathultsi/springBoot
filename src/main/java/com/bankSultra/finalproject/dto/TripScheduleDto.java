package com.bankSultra.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//@Getter
//@Setter
@Data
////@AllArgsConstructor
//@NoArgsConstructor
public class TripScheduleDto {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tripDate;
    private int availableSeats;

    private TripDto tripDetail;


    private Set<TicketMapDto> ticketsSold = new HashSet<>();

    private List<TicketMapDto> tickets;

}
