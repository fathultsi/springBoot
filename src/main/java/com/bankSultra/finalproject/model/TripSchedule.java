package com.bankSultra.finalproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(schema = "FP")
public class TripSchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date tripDate;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "tripDetail")
    private Trip tripDetail;

    @ManyToMany()
    @JoinTable(
            schema = "FP",
            name = "ticketsSold",
            joinColumns = {@JoinColumn(name = "tripschedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id")}
    )
    private Set<Ticket> ticketsSold = new HashSet<>();

    @OneToMany(mappedBy = "tripSchedule", cascade = CascadeType.ALL)
    private List<Ticket> tickets;




//        private int seatNumber;
//        private Boolean cancellable;
//        @JsonFormat(pattern = "yyyy-MM-dd")
//        private Date journeyDate;


}
