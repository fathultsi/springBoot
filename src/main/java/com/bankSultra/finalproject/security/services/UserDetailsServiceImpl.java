package com.bankSultra.finalproject.security.services;

import com.bankSultra.finalproject.mappers.UserMapper;
import com.bankSultra.finalproject.security.beans.UserPrincipal;
import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.repository.UserListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserListRepository userListRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        UserList user = userListRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Email Tdak ditumakn"));
        UserPrincipal pr = UserMapper.userToPrincipal(user);
        pr.getAuthorities().stream().map(auth -> auth.getAuthority()).forEach(System.out::println);




        return UserMapper.userToPrincipal(user);
    }

}
