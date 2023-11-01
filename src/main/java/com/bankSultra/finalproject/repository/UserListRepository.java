package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.dto.UserDto;
import com.bankSultra.finalproject.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserListRepository extends JpaRepository<UserList, Long > {


    Optional<UserList> findByEmail(String email);


    UserList getById(int id);
}
