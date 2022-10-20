package com.ozkaraca.exceptionhandling.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class FlightRequest {

    @NotNull(message = "airlineCode can not be null")
    @NotEmpty(message = "airlineCode can not be empty")
    private String airlineCode;

    @NotNull
    private String sourceAirportCode;

    @NotNull
    private String destinationAirportCode;

    @NotNull
    private LocalDate flightDate;

    @NotNull
    private LocalTime flightTime;
}
