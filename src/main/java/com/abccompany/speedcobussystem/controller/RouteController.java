package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Route;
import com.abccompany.speedcobussystem.model.dto.RouteDto;
import com.abccompany.speedcobussystem.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * Add routes with their name (eg: M44, H22, G40)
     *
     */
    @PostMapping
    public ResponseEntity<RouteDto> addRouteByName(@RequestBody final RouteDto routeDto) {
        // TODO:code should validate can be multiple
        Route route = Route.valueOf(routeDto);
        return new ResponseEntity<>(RouteDto.valueOf(
                routeService.createRoute(route)), HttpStatus.CREATED);
    }

    /**
     * Remove routes with their name (eg: M44, H22, G40)
     *
     */
    @DeleteMapping("/{name}")
    public ResponseEntity<RouteDto> removeRoute(@PathVariable("name") final String name) {
        // TODO: should check the null value
        return new ResponseEntity<>(RouteDto.valueOf(routeService.removeRouteByName(name)), HttpStatus.OK);
    }

}
