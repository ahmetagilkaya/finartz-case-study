package tr.com.finartz.casestudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.finartz.casestudy.model.entity.Airline;
import tr.com.finartz.casestudy.repository.AirlineRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Transactional(readOnly = true)
    public Airline findAirlineById(Long id){
        return airlineRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No airline record for this id = %d could be found.", id)));
    }

    @Transactional(readOnly = true)
    public Airline findByAirlineName(String airlineName){
        return airlineRepository
                .findByAirlineName(airlineName)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No airline record for this airlineName = %s could be found.", airlineName)));
    }

    @Transactional(readOnly = true)
    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll();
    }

    @Transactional
    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Transactional
    public void deleteAirlineById(Long id) {
        airlineRepository.deleteById(id);
    }

}
