package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.dto.TicketDTO;
import com.bankSultra.finalproject.dto.TicketMapDto;
import com.bankSultra.finalproject.model.Ticket;
import com.bankSultra.finalproject.model.TripSchedule;
import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.repository.TicketRepository;
import com.bankSultra.finalproject.repository.TripSchedulesRepository;
import com.bankSultra.finalproject.repository.UserListRepository;
import com.bankSultra.finalproject.security.jwt.JwtTokenProvider;
import com.bankSultra.finalproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.bankSultra.finalproject.mappers.DtoMapper.ticketToDto;


@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TripSchedulesRepository tripSchedulesRepository;
    @Autowired
    private UserListRepository userListRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;



    @Override
    public List<TicketMapDto> getAllTicket() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(a -> ticketToDto(a))
                .collect(Collectors.toList());
//        return ticketRepository.findAll();
    }

    @Override
    public Boolean cekTickeById(Long id) {
        return ticketRepository.existsById(id);
    }

    @Override
    public Ticket createTicket(TicketDTO ticketDTO) {

        Ticket ticket = new Ticket();
        TripSchedule findSchedule = tripSchedulesRepository.findById(ticketDTO.getIdScedule()).orElse(null);

        ticket.setSeatNumber(ticketDTO.getSeatNumber());
        ticket.setCancellable(false);
        ticket.setJourneyDate(findSchedule.getTripDate());
        ticket.setTripSchedule(findSchedule);

//        TripSchedule tripSchedule1= findSchedule

//        sampai disini, buat fungsi untuk ambil data by id karena jpa opsional
        return ticketRepository.save(ticket);
    }

    @Override
    public void insertMapTripTicket(Long ticket_id, String token) {

       Ticket ticket = ticketRepository.findById(ticket_id).orElse(null);

        String getId= jwtTokenProvider.getIdToken(token);

        Long idLong = Long.parseLong(getId);

        UserList userList = userListRepository.findById(idLong).orElse(null);

        ticket.setPassenger(userList);

        ticketRepository.save(ticket);

        ticketRepository.insertMMTripScheduleTicket(ticket.getTripSchedule().getId(),ticket_id);

    }
}
