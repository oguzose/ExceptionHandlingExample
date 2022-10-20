# Spring Exception Handling with Example

# 3rd party libraries:
H2 database - for persistence,
Lombok - for code generation,

# Important Annotations;
@ControllerAdvice, @ExceptionHandler

Requests and URL;
1) Post api endpoint is: http://localhost:8080/api/flight

This api makes saveFlight process.
If you save flight to the same destinations 
more than 3 flights a day, you get this error;<br />
FlightCountException: "You cannot add more than 3 flights on the same day".

2) Delete api endpoint is: http://localhost:8080/api/flight/{id}

 You can delete flight with flightId. But if flightId is not exist
 on your db, you get this error;<br />
 NoDataFoundException: "No data found flightId: {id}".


Example request and url;<br />

http://localhost:8080/api/flight <br />
{
    "airlineCode": "PGS",
    "sourceAirportCode": "SAW",
    "destinationAirportCode": "MUN",
    "flightDate": [
        2022,
        2,
        25
        ],
    "flightTime": "10:24"
}