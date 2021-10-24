package com.abccompany.speedcobussystem.service;

import com.abccompany.speedcobussystem.model.Route;
import com.abccompany.speedcobussystem.model.Stop;
import com.abccompany.speedcobussystem.repository.StopRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StopService {

    private final StopRepository stopRepository;
    private final RouteService routeService;

    public StopService(StopRepository stopRepository, RouteService routeService) {
        this.stopRepository = stopRepository;
        this.routeService = routeService;
    }

    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }

    //TODO: Exception handle if not Found
    public Stop findStopByCode(String code) {
        return stopRepository.findStopByCode(code);
    }

    public Stop createStopByCode(String code) {
        Stop stop = new Stop();
        stop.setCode(code);
        return createStop(stop);
    }

    public Stop removeStopByCode(String code) {
        Stop stop = findStopByCode(code);
        stopRepository.delete(stop);
        return stop;
    }

    public Stop addStopToRoute(String code, Long id) {
        Stop stop = findStopByCode(code);
        Route route = routeService.getRoute(id);
        stop.setRoute(route);
        route.addStop(stop);
        return stop;
    }
}
