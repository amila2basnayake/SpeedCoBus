package com.abccompany.speedcobussystem.service;

import com.abccompany.speedcobussystem.model.Route;
import com.abccompany.speedcobussystem.repository.RouteRepository;
import com.abccompany.speedcobussystem.service.exception.RouteException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    //TODO:Exception handle if not Found
    public Route findRouteByName(String name) {
        return routeRepository.findRouteByName(name);
    }

    public Route removeRouteByName(String routeName) {
        Route route = findRouteByName(routeName);
        routeRepository.delete(route);
        return route;
    }

    public Route createRouteByName(String routeName) {
        Route route = new Route();
        route.setName(routeName);
        return createRoute(route);
    }

    public Route getRoute(Long id) {
        return routeRepository.findById(id).orElseThrow(() -> new RouteException(id));
    }
}
