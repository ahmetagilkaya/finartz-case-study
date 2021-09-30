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
import tr.com.finartz.casestudy.model.dto.route.RouteCreateDTO;
import tr.com.finartz.casestudy.model.dto.route.RouteDTO;
import tr.com.finartz.casestudy.model.dto.route.RouteEditDTO;
import tr.com.finartz.casestudy.service.RouteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/route")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;
    private final DTOtoEntityHelper dtOtoEntityHelper;
    private final DTOMapper dtoMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouteDTO> createRoute(@Valid @RequestBody RouteCreateDTO routeCreateDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(routeService.saveRoute(dtOtoEntityHelper.convertRouteCreateDTOtoRoute(routeCreateDTO)), RouteDTO.class), HttpStatus.OK);
    }

    @PutMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouteDTO> editRoute(@Valid @RequestBody RouteEditDTO routeEditDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(routeService.saveRoute(dtOtoEntityHelper.convertRouteEditDTOtoRoute(routeEditDTO)), RouteDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteRouteById(@RequestParam(name = "id") Long id)  {
        routeService.deleteRouteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouteDTO> findRouteById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(dtoMapper.mapModel(routeService.findRouteById(id), RouteDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-all-routes-by-route-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RouteDTO>> findAllRoutesByRouteName(@RequestParam(name = "routeName") String routeName) {
        return new ResponseEntity<>(dtoMapper.mapListModel(routeService.findAllByRouteName(routeName), RouteDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RouteDTO>> findAllRoutes() {
        return new ResponseEntity<>(dtoMapper.mapListModel(routeService.findAllRoutes(), RouteDTO.class), HttpStatus.OK);
    }
    
}
