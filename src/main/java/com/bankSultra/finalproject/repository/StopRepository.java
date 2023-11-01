package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long > {





}
