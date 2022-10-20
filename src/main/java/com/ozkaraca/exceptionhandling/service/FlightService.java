package com.ozkaraca.exceptionhandling.service;

import com.ozkaraca.exceptionhandling.exception.FlightCountException;
import com.ozkaraca.exceptionhandling.exception.NoDataFoundException;
import com.ozkaraca.exceptionhandling.model.FlightModel;
import com.ozkaraca.exceptionhandling.model.FlightRequest;
import com.ozkaraca.exceptionhandling.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    public FlightModel saveFlightInfo(FlightRequest flightRequest) {

        FlightModel flightModel = new FlightModel();

        flightModel.setAirlineCode(flightRequest.getAirlineCode());
        flightModel.setSourceAirportCode(flightRequest.getSourceAirportCode());
        flightModel.setDestinationAirportCode(flightRequest.getDestinationAirportCode());
        flightModel.setFlightDate(flightRequest.getFlightDate());
        flightModel.setFlightTime(flightRequest.getFlightTime());

        final long flightCount = flightRepository.countByFlightDateAndAirlineCode(flightRequest.getFlightDate(), flightRequest.getAirlineCode());

        if (flightCount == 3) {
            throw new FlightCountException("You cannot add more than 3 flights on the same day");
        }
        flightRepository.save(flightModel);
        return flightModel;
    }

    public FlightModel delete(Long id) {
        return flightRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException("flightId: " + id));
    }
}
