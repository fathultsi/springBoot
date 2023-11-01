package com.bankSultra.finalproject.controller;


import com.bankSultra.finalproject.dto.UserUpdateDto;
import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bankSultra.finalproject.mappers.DtoMapper.userDtoToEntity;

@RestController
//@Api(value = "Bus Reservation controller", description = "Operation pertaining to agency management and ticket issue in the BRS aplication")
@RequestMapping(value = "/api/v1/userManagement")
@Validated
public class UserManagmentController {


    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getAllUser")
    List<UserUpdateDto> getAllUser() {
        return userService.getAllUser();
    }

    @ApiOperation(value = "Update Profile", response = Iterable.class)
    @PreAuthorize("hasRole('ADMIN') or hasRole('TSI')")
    @PutMapping(value ="/updateUser", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDto userUpdateDto,
                                        @RequestHeader("Authorization") String authorizationHeader){


        // Check if the Authorization header is present and starts with "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        // Extract the token (excluding "Bearer ")
            String token = authorizationHeader.substring(7);
            // Now you have the Bearer token in the 'token' variable, and you can use it as needed.
        } else {
            // The Authorization header is missing or not in the expected format
            return ResponseEntity.badRequest().body("Invalid or missing Bearer token.");
        }

        UserList userList = userService.findByemail(userUpdateDto.getEmail()).orElse(null);
        if (userList == null){
            return ResponseEntity.badRequest().body(userUpdateDto.getEmail()+" blum terdatar silahkan SignUp terlebih dahulu");
        }
        userUpdateDto.setId(userList.getId());
        userUpdateDto.setPassword(userList.getPassword());
        userUpdateDto.setRoles(userList.getRole());

        UserList updateUser = userDtoToEntity(userUpdateDto);

        try {
            userService.updateUser(updateUser);
            return new ResponseEntity<>("Berhasil Update user : " + userUpdateDto.getEmail(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
