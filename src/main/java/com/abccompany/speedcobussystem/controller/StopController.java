package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Stop;
import com.abccompany.speedcobussystem.model.dto.StopDto;
import com.abccompany.speedcobussystem.service.StopService;
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
    @PostMapping("/{code}/route/{id}")
    public ResponseEntity<StopDto> addStopToRoute(@PathVariable("code")  final String code, @PathVariable("id")  final Long id) {
        // TODO: should validate
        return new ResponseEntity<>(StopDto.valueOf(stopService.addStopToRoute(code, id)), HttpStatus.CREATED);
    }

    /**
     *   Removing stops with their code (eg: A1, B3, Q42)
     *
     */
    @DeleteMapping("/{code}")
    public ResponseEntity<StopDto> removeStop(@PathVariable("code") final String code) {
        // TODO: should validate
        return new ResponseEntity<>(StopDto.valueOf(stopService.removeStopByCode(code)), HttpStatus.OK);
    }


}
