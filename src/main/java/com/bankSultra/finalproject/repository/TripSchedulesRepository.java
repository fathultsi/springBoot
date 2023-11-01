package com.bankSultra.finalproject.repository;

import com.bankSultra.finalproject.model.TripSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TripSchedulesRepository extends JpaRepository<TripSchedule, Long > {



    List<TripSchedule> findByTripDate(Date tripDate);


}
