package com.bankSultra.finalproject.controller.reservation;

import com.bankSultra.finalproject.dto.UserDto;
import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api(value = "User Controller", description = "Operation pertaining to user management in the BRS application")
@RequestMapping(value = "/api/v1")
@Validated
public class UserController {

    @Autowired
    UserService userService;


//    @ApiOperation(value = "View a list of available User", response = Iterable.class)
//    @PreAuthorize("hasRole('ADMIN') or hasRole('TSI')")
//    @GetMapping(value = "/getAllUser")
//    List<UserList> getAll() {
//        return userService.getAllUser();
//    }

    @ApiOperation(value = "Signup", response = Iterable.class)
    @PostMapping(value ="/user/signup", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createUser(@RequestBody UserList userList){


        UserList userDto = userService.findByemail(userList.getEmail()).orElse(null);

//        Boolean cekTripById = tripService.cekTripById(tripSchedule.getId());
//
        if (userDto != null){
            return ResponseEntity.badRequest().body(userList.getEmail()+" Sudah Terdaftar");
        }
        try {
            userService.createUser(userList);
            return new ResponseEntity<>("Berhasil Signup", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
