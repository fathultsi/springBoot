package com.bankSultra.finalproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Setter

@Table(schema = "FP")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int seatNumber;
    private Boolean cancellable;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date journeyDate;


    @ManyToOne
    @JoinColumn(name = "passenger")
    private UserList passenger;


    @ManyToOne
    @JoinColumn(name = "tripSchedule", referencedColumnName = "id")
    @NotNull
    private TripSchedule tripSchedule;

    public Long getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Boolean getCancellable() {
        return cancellable;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public UserList getPassenger() {
        return passenger;
    }

    @JsonIgnore
    public TripSchedule getTripSchedule() {
        return tripSchedule;
    }
}
