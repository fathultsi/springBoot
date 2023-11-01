package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long > {



//    List<Ticket> findBySourceStopIdAndDestStopId(Long sourceStop, Long destStop);

    @Modifying
    @Query(value = "INSERT INTO FP.TICKETS_SOLD  VALUES (:tripschedule_id, :ticket_id)", nativeQuery = true)
    void insertMMTripScheduleTicket(@Param("tripschedule_id") Long tripschedule_id, @Param("ticket_id") Long ticket_id);


}
