package com.ozkaraca.exceptionhandling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
public class FlightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String airlineCode;

    private String sourceAirportCode;

    private String destinationAirportCode;

    private LocalDate flightDate;

    private LocalTime flightTime;

}
