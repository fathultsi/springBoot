package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.model.Bus;
import com.bankSultra.finalproject.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long > {



    List<Trip> findBySourceStopIdAndDestStopId(Long sourceStop, Long destStop);



}
