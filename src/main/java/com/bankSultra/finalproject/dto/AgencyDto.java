package com.bankSultra.finalproject.dto;

import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Trip;
import com.bankSultra.finalproject.model.UserList;
import lombok.*;

import java.util.List;


//@Getter
//@Setter
@Data
////@AllArgsConstructor
//@NoArgsConstructor
public class AgencyDto {

    private Long id;


    private String code;
    private String name;
    private String details;



    private UserDto owner;



    private List<Bus> busList;

    private List<Trip> trips ;

}
