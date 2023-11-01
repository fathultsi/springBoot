package com.bankSultra.finalproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


//@Getter
//@Setter
@Data
//@Accessors(chain = true)
//@NoArgsConstructor
public class UserDto {
    @JsonIgnore
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
//    private
}
