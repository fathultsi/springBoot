package com.bankSultra.finalproject.mappers;


import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.security.beans.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserPrincipal userToPrincipal(UserList userList) {

        List<SimpleGrantedAuthority> authorities = userList.getRole()
                .stream()
                .map(role ->new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());

        return new UserPrincipal()
                .setUsername(userList.getEmail())
                .setPassword(userList.getPassword())
                .setEnabled(true)
                .setAuthorities(authorities);

    }

}
