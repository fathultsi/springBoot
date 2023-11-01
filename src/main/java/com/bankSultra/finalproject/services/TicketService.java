package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.dto.TicketDTO;
import com.bankSultra.finalproject.dto.TicketMapDto;
import com.bankSultra.finalproject.model.Ticket;

import java.util.List;


public interface TicketService {

    List<TicketMapDto> getAllTicket();

    Boolean cekTickeById(Long id);
    Ticket createTicket(TicketDTO ticketDTO);

    void insertMapTripTicket(Long ticket_id, String token);
}
