package com.bankSultra.finalproject.dto;

import com.bankSultra.finalproject.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


//@Getter
//@Setter
@Data
//@Accessors(chain = true)
//@NoArgsConstructor
public class UserUpdateDto {

    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Set<Role> roles = new HashSet<>();
//    private
}
