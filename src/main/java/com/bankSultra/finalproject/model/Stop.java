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
public class Stop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String code;
    private String name;
    private String detail;

    @OneToMany
    private List<Trip> trips;

}
