package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.dto.UserDto;
import com.bankSultra.finalproject.dto.UserUpdateDto;
import com.bankSultra.finalproject.model.Role;
import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.repository.RoleRepository;
import com.bankSultra.finalproject.repository.UserListRepository;
import com.bankSultra.finalproject.services.UserService;
import org.dom4j.rule.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bankSultra.finalproject.mappers.DtoMapper.userEmtityToDto;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserListRepository userListRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    public List<UserUpdateDto> getAllUser(){
       List<UserList> userList = userListRepository.findAll();

       List<UserUpdateDto> userUpdateDtos = userList.stream()
                .map(a->userEmtityToDto(a))
                .collect(Collectors.toList());
        return  userUpdateDtos;
    }

    @Override
    public UserList createUser(UserList userList) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Role role = roleRepository.findById(1L).orElse(null);

        userList.setPassword(passwordEncoder.encode(userList.getPassword()));

        userListRepository.save(userList);
        roleRepository.insertUserRole(userList.getId(), role.getId());

        return userList;
    }

    @Override
    public UserList updateUser(UserList userList) {
        return userListRepository.save(userList);
    }

    @Override
    public Optional<UserList> findByemail(String email) {
        return userListRepository.findByEmail(email);
    }

}

//    @Autowired
//    public UserList createUserList(UserList userList){
//        return userListRepository.save(userList);
//    };
//    @Autowired
//    public UserList createUser2(UserList userList){
//            return userListRepository.getById(1);
//    }



