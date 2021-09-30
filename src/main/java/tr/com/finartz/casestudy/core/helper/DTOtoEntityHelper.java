package tr.com.finartz.casestudy.core.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tr.com.finartz.casestudy.model.dto.airline.AirlineCreateDTO;
import tr.com.finartz.casestudy.model.dto.airline.AirlineEditDTO;
import tr.com.finartz.casestudy.model.dto.airport.AirportCreateDTO;
import tr.com.finartz.casestudy.model.dto.airport.AirportEditDTO;
import tr.com.finartz.casestudy.model.dto.flight.FlightCreateDTO;
import tr.com.finartz.casestudy.model.dto.flight.FlightEditDTO;
import tr.com.finartz.casestudy.model.dto.route.RouteCreateDTO;
import tr.com.finartz.casestudy.model.dto.route.RouteEditDTO;
import tr.com.finartz.casestudy.model.dto.ticket.TicketCreateDTO;
import tr.com.finartz.casestudy.model.dto.ticket.TicketEditDTO;
import tr.com.finartz.casestudy.model.entity.Airline;
import tr.com.finartz.casestudy.model.entity.Airport;
import tr.com.finartz.casestudy.model.entity.Flight;
import tr.com.finartz.casestudy.model.entity.Route;
import tr.com.finartz.casestudy.model.entity.Ticket;
import tr.com.finartz.casestudy.service.AirlineService;
import tr.com.finartz.casestudy.service.AirportService;
import tr.com.finartz.casestudy.service.FlightService;
import tr.com.finartz.casestudy.service.RouteService;
import tr.com.finartz.casestudy.service.TicketService;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class DTOtoEntityHelper {

    private final AirlineService airlineService;
    private final AirportService airportService;
    private final RouteService routeService;
    private final FlightService flightService;
    private final TicketService ticketService;

    public Airline convertAirlineCreateDTOtoAirline(AirlineCreateDTO airlineCreateDTO){
        return setAirlineFields(new Airline(), airlineCreateDTO);
    }

    public Airline convertAirlineEditDTOtoAirline(AirlineEditDTO airlineEditDTO) {
        return setAirlineFields(airlineService.findAirlineById(airlineEditDTO.getId()), airlineEditDTO);
    }

    public Airport convertAirportCreateDTOtoAirport(AirportCreateDTO airportCreateDTO){
        return setAirportFields(new Airport(), airportCreateDTO);
    }

    public Airport convertAirportEditDTOtoAirport(AirportEditDTO airportEditDTO){
        return setAirportFields(airportService.findAirportById(airportEditDTO.getId()), airportEditDTO);
    }

    public Flight convertFlightCreateDTOtoFlight(FlightCreateDTO flightCreateDTO){
        return setFlightFields(new Flight(), flightCreateDTO);
    }

    public Flight convertFlightEditDTOtoFlight(FlightEditDTO flightEditDTO){
        return setFlightFields(flightService.findFlightById(flightEditDTO.getId()), flightEditDTO);
    }

    public Route convertRouteCreateDTOtoRoute(RouteCreateDTO routeCreateDTO){
        return setRouteFields(new Route(), routeCreateDTO);
    }

    public Route convertRouteEditDTOtoRoute(RouteEditDTO routeEditDTO){
        return setRouteFields(routeService.findRouteById(routeEditDTO.getId()), routeEditDTO);
    }

    public Ticket convertTicketCreateDTOtoTicket(TicketCreateDTO ticketCreateDTO){
        return setTicketFields(new Ticket(), ticketCreateDTO);
    }

    public Ticket convertTicketEditDTOtoTicket(TicketEditDTO ticketEditDTO){
        return setTicketFields(ticketService.findTicketById(ticketEditDTO.getId()), ticketEditDTO);
    }

    private Airline setAirlineFields(Airline airline, AirlineCreateDTO airlineCreateDTO){
        airline.setAirlineName(airlineCreateDTO.getAirlineName());
        airline.setEmail(airlineCreateDTO.getEmail());
        airline.setPhoneNumber(airlineCreateDTO.getPhoneNumber());
        return airline;
    }

    private Airport setAirportFields(Airport airport, AirportCreateDTO airportCreateDTO){
        airport.setAirportName(airportCreateDTO.getAirportName());
        airport.setAirportCode(airportCreateDTO.getAirportCode());
        airport.setAirportCountry(airportCreateDTO.getAirportCountry());
        airport.setAirportCity(airportCreateDTO.getAirportCity());
        return airport;
    }

    private Flight setFlightFields(Flight flight, FlightCreateDTO flightCreateDTO){
        flight.setFlightName(flightCreateDTO.getFlightName());
        flight.setFlightDate(flightCreateDTO.getFlightDate());
        flight.setFlightTimeMinutes(flightCreateDTO.getFlightTimeMinutes());
        flight.setQuota(flightCreateDTO.getQuota());
        flight.setPrice(flightCreateDTO.getPrice());
        flight.setAirline(airlineService.findAirlineById(flightCreateDTO.getAirlineId()));
        flight.setRoute(routeService.findRouteById(flightCreateDTO.getRouteId()));
        return flight;
    }

    private Route setRouteFields(Route route, RouteCreateDTO routeCreateDTO){
        route.setRouteName(routeCreateDTO.getRouteName());
        route.setFrom(airportService.findAirportById(routeCreateDTO.getFromAirportId()));
        route.setTo(airportService.findAirportById(routeCreateDTO.getToAirportId()));
        return route;
    }

    private Ticket setTicketFields(Ticket ticket, TicketCreateDTO ticketCreateDTO){
        ticket.setFlight(flightService.findFlightById(ticketCreateDTO.getFlightId()));
        ticket.setPurchasedCreditCardNumber(ticketCreateDTO.getPurchasedCreditCardNumber());
        return ticket;
    }

}
