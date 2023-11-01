package com.bankSultra.finalproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(schema = "FP")
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fare;

    @JsonFormat(pattern = "hh:mm:ss")
    private Time journeyTime;

    @ManyToOne
    @JoinColumn(name = "sourceStop",referencedColumnName = "id")
    private Stop sourceStop;

    @ManyToOne
    @JoinColumn(name = "destStop",referencedColumnName = "id")
    private Stop destStop;

    @ManyToOne
    @JoinColumn(name = "bus")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "agency")
    private Agency agency;









}
