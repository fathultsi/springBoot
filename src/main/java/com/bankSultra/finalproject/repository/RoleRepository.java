package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long > {



    @Modifying
    @Query(value = "INSERT INTO FP.USER_ROLE  VALUES (:user_id, :role_id)", nativeQuery = true)
    void insertUserRole(@Param("user_id") Long user_id, @Param("role_id") Long role_id);


}
