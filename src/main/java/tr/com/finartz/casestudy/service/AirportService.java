package tr.com.finartz.casestudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.finartz.casestudy.model.entity.Airport;
import tr.com.finartz.casestudy.repository.AirportRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    
    private final AirportRepository airportRepository;

    @Transactional(readOnly = true)
    public Airport findAirportById(Long id){
        return airportRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No airport record for this id = %d could be found.", id)));
    }

    @Transactional(readOnly = true)
    public Airport findByAirportName(String airportName){
        return airportRepository
                .findByAirportName(airportName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No airport record for this airportName = %s could be found.", airportName)));
    }

    @Transactional(readOnly = true)
    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    @Transactional
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Transactional
    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }
    
}
