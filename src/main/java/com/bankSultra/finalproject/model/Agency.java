package com.bankSultra.finalproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Table(schema = "FP")
public class Agency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String code;
    private String name;
    private String details;


    @ManyToOne
    @JoinColumn(name = "owner")
    private UserList owner;


    @OneToMany
    private List<Bus> busList;

    @OneToMany
    private List<Trip> trips ;



}
