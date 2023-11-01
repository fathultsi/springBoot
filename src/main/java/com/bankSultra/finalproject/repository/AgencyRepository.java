package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.model.Agency;
import com.bankSultra.finalproject.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long > {





}
