package tr.com.finartz.casestudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.finartz.casestudy.model.entity.Route;
import tr.com.finartz.casestudy.repository.RouteRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    @Transactional(readOnly = true)
    public Route findRouteById(Long id){
        return routeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No route record for this id = %d could be found.", id)));
    }

    @Transactional(readOnly = true)
    public List<Route> findAllByRouteName(String routeName){
        return routeRepository.findAllByRouteName(routeName);
    }

    @Transactional(readOnly = true)
    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }

    @Transactional
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    @Transactional
    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);
    }
    
}
