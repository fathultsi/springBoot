package com.bankSultra.finalproject.mappers;

import com.bankSultra.finalproject.dto.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMapper {

    public static ResponseEntity<Object> errorToEntity(ResponseError err, HttpStatus status) {
        return new ResponseEntity<Object>(err, status);
    }
}
