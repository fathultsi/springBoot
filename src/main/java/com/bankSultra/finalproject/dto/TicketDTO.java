package com.bankSultra.finalproject.dto;

import com.bankSultra.finalproject.model.TripSchedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TicketDTO {

    private int seatNumber;

    private Long idScedule;
}
