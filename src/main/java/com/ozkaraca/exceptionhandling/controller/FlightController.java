package com.ozkaraca.exceptionhandling.controller;

import com.ozkaraca.exceptionhandling.model.FlightModel;
import com.ozkaraca.exceptionhandling.model.FlightRequest;
import com.ozkaraca.exceptionhandling.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;

    @PostMapping()
    public ResponseEntity<FlightModel> saveFlight(@RequestBody @Validated FlightRequest flightRequest) {

        final FlightModel flightModel = flightService.saveFlightInfo(flightRequest);
        return new ResponseEntity<>(flightModel, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FlightModel> delete(@PathVariable Long id) {

        final FlightModel flightModel = flightService.delete(id);
        return new ResponseEntity<>(flightModel, HttpStatus.ACCEPTED);
    }
}
