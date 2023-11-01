package com.bankSultra.finalproject.security.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;



@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class LoginRequest {


    private String email;


    private String password;

}
