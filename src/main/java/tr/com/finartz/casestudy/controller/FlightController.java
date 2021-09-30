package tr.com.finartz.casestudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.finartz.casestudy.core.helper.DTOtoEntityHelper;
import tr.com.finartz.casestudy.core.mapper.DTOMapper;
import tr.com.finartz.casestudy.model.dto.flight.FlightCreateDTO;
import tr.com.finartz.casestudy.model.dto.flight.FlightDTO;
import tr.com.finartz.casestudy.model.dto.flight.FlightEditDTO;
import tr.com.finartz.casestudy.service.FlightService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;
    private final DTOtoEntityHelper dtOtoEntityHelper;
    private final DTOMapper dtoMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> createFlight(@Valid @RequestBody FlightCreateDTO flightCreateDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(flightService.saveFlight(dtOtoEntityHelper.convertFlightCreateDTOtoFlight(flightCreateDTO)), FlightDTO.class), HttpStatus.OK);
    }

    @PutMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> editFlight(@Valid @RequestBody FlightEditDTO flightEditDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(flightService.saveFlight(dtOtoEntityHelper.convertFlightEditDTOtoFlight(flightEditDTO)), FlightDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteFlightById(@RequestParam(name = "id") Long id)  {
        flightService.deleteFlightById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> findFlightById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(dtoMapper.mapModel(flightService.findFlightById(id), FlightDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-flight-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> findFlightByFlightName(@RequestParam(name = "flightName") String flightName) {
        return new ResponseEntity<>(dtoMapper.mapModel(flightService.findByFlightName(flightName), FlightDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FlightDTO>> findAllFlights() {
        return new ResponseEntity<>(dtoMapper.mapListModel(flightService.findAllFlights(), FlightDTO.class), HttpStatus.OK);
    }
    
}
