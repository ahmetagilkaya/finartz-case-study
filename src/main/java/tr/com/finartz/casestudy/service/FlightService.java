package tr.com.finartz.casestudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.finartz.casestudy.model.entity.Flight;
import tr.com.finartz.casestudy.repository.FlightRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    @Transactional(readOnly = true)
    public Flight findFlightById(Long id){
        return flightRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No flight record for this id = %d could be found.", id)));
    }

    @Transactional(readOnly = true)
    public Flight findByFlightName(String flightName){
        return flightRepository
                .findByFlightName(flightName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No flight record for this flightName = %s could be found.", flightName)));
    }

    @Transactional(readOnly = true)
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Transactional
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }
    
}
