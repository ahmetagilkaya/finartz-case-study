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
import tr.com.finartz.casestudy.model.dto.airline.AirlineCreateDTO;
import tr.com.finartz.casestudy.model.dto.airline.AirlineDTO;
import tr.com.finartz.casestudy.model.dto.airline.AirlineEditDTO;
import tr.com.finartz.casestudy.service.AirlineService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/airline")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;
    private final DTOtoEntityHelper dtOtoEntityHelper;
    private final DTOMapper dtoMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirlineDTO> createAirline(@Valid @RequestBody AirlineCreateDTO airlineCreateDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(airlineService.saveAirline(dtOtoEntityHelper.convertAirlineCreateDTOtoAirline(airlineCreateDTO)), AirlineDTO.class), HttpStatus.OK);
    }

    @PutMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirlineDTO> editAirline(@Valid @RequestBody AirlineEditDTO airlineEditDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(airlineService.saveAirline(dtOtoEntityHelper.convertAirlineEditDTOtoAirline(airlineEditDTO)), AirlineDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteAirlineById(@RequestParam(name = "id") Long id)  {
        airlineService.deleteAirlineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirlineDTO> findAirlineById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(dtoMapper.mapModel(airlineService.findAirlineById(id), AirlineDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-airline-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirlineDTO> findAirlineByAirlineName(@RequestParam(name = "airlineName") String airlineName) {
        return new ResponseEntity<>(dtoMapper.mapModel(airlineService.findByAirlineName(airlineName), AirlineDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirlineDTO>> findAllAirlines() {
        return new ResponseEntity<>(dtoMapper.mapListModel(airlineService.findAllAirlines(), AirlineDTO.class), HttpStatus.OK);
    }

}
