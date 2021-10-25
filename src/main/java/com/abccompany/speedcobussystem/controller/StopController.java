package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Bus;
import com.abccompany.speedcobussystem.model.Route;
import com.abccompany.speedcobussystem.model.Stop;
import com.abccompany.speedcobussystem.model.dto.LineDto;
import com.abccompany.speedcobussystem.model.dto.RouteDto;
import com.abccompany.speedcobussystem.model.dto.StopDto;
import com.abccompany.speedcobussystem.service.StopService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stop")
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    /**
     *   Adding stops with their code (eg: A1, B3, Q42)
     *
     */
    @PostMapping
    public ResponseEntity<StopDto> addStopByCode(@RequestBody final StopDto stopDto) {
        // TODO:code should validate can be multiple
        Stop stop = Stop.valueOf(stopDto);
        return new ResponseEntity<>(StopDto.valueOf(
                stopService.createStop(stop)), HttpStatus.CREATED);
    }

    /**
     *   Add Stop with route
     *
     */
    @PostMapping("/codeid/{code}/route/{id}")
    public ResponseEntity<StopDto> addStopToRoute(@PathVariable("code")  final String code, @PathVariable("id")  final Long id) {
        return new ResponseEntity<>(StopDto.valueOf(stopService.addStopToRoute(code, id)), HttpStatus.CREATED);
    }

    /**
     *   Removing stops with their code (eg: A1, B3, Q42)
     *
     */
    @DeleteMapping("/{code}")
    public ResponseEntity<StopDto> removeStop(@PathVariable("code") final String code) {
        return new ResponseEntity<>(StopDto.valueOf(stopService.removeStopByCode(code)), HttpStatus.OK);
    }


}
