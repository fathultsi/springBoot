package com.bankSultra.finalproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(schema = "FP")
public class Bus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String code;
    private int capacity;
    private String make;
   // private String owner;


    @ManyToOne()
    @JoinColumn(
            name = "agency"
    )
    private Agency agency;

    @OneToMany
    private List<Trip> trips;




}
