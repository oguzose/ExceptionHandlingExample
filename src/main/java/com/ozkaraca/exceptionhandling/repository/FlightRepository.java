package com.ozkaraca.exceptionhandling.repository;

import com.ozkaraca.exceptionhandling.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FlightRepository extends JpaRepository<FlightModel, Long> {

    long countByFlightDateAndAirlineCode(LocalDate flightDate, String airlineCode);

}
