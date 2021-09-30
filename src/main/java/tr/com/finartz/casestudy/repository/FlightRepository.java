package tr.com.finartz.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.finartz.casestudy.model.entity.Airline;
import tr.com.finartz.casestudy.model.entity.Flight;
import tr.com.finartz.casestudy.model.entity.Route;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightName(String flightName);
    List<Flight> findAllByAirline(Airline airline);
    List<Flight> findAllByRoute(Route route);

}
