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
import tr.com.finartz.casestudy.model.dto.airport.AirportCreateDTO;
import tr.com.finartz.casestudy.model.dto.airport.AirportDTO;
import tr.com.finartz.casestudy.model.dto.airport.AirportEditDTO;
import tr.com.finartz.casestudy.service.AirportService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/airport")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;
    private final DTOtoEntityHelper dtOtoEntityHelper;
    private final DTOMapper dtoMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> createAirport(@Valid @RequestBody AirportCreateDTO airportCreateDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(airportService.saveAirport(dtOtoEntityHelper.convertAirportCreateDTOtoAirport(airportCreateDTO)), AirportDTO.class), HttpStatus.OK);
    }

    @PutMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> editAirport(@Valid @RequestBody AirportEditDTO airportEditDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(airportService.saveAirport(dtOtoEntityHelper.convertAirportEditDTOtoAirport(airportEditDTO)), AirportDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteAirportById(@RequestParam(name = "id") Long id)  {
        airportService.deleteAirportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> findAirportById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(dtoMapper.mapModel(airportService.findAirportById(id), AirportDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-airport-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> findAirportByAirportName(@RequestParam(name = "airportName") String airportName) {
        return new ResponseEntity<>(dtoMapper.mapModel(airportService.findByAirportName(airportName), AirportDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> findAllAirports() {
        return new ResponseEntity<>(dtoMapper.mapListModel(airportService.findAllAirports(), AirportDTO.class), HttpStatus.OK);
    }
    
}
