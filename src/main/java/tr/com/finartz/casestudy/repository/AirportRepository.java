package tr.com.finartz.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.finartz.casestudy.model.entity.Airport;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Optional<Airport> findByAirportName(String airportName);
    Optional<Airport> findByAirportCode(String airportCode);
    List<Airport> findAllByAirportCountry(String airportCountry);
    List<Airport> findAllByAirportCity(String airportCity);

}
