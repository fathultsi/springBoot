package com.bankSultra.finalproject.services;



import com.bankSultra.finalproject.dto.UserDto;
import com.bankSultra.finalproject.dto.UserUpdateDto;
import com.bankSultra.finalproject.model.UserList;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<UserUpdateDto> getAllUser();

//   UserList createUserList(UserList userList);
//    UserList createUser2(UserList userList);
    UserList createUser(UserList userList);

    UserList updateUser(UserList userList);

    Optional<UserList> findByemail(String email);



}
