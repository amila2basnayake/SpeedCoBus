package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Bus;
import com.abccompany.speedcobussystem.model.Schedule;
import com.abccompany.speedcobussystem.model.dto.BusDto;
import com.abccompany.speedcobussystem.model.dto.ScheduleDto;
import com.abccompany.speedcobussystem.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    /**
     * Add bus with their registration (eg: ABC-123)
     */
    @PostMapping
    public ResponseEntity<BusDto> addBus(@RequestBody final BusDto busDto) {
        Bus bus = Bus.valueOf(busDto);
        return new ResponseEntity<>(BusDto.valueOf(
                busService.createBus(bus)), HttpStatus.CREATED);
    }

    /**
     * Removing buses with their registration (eg: ABC-123)
     */
    @DeleteMapping("{code}")
    public ResponseEntity<BusDto> removeBus(@PathVariable("code") final String code) {
        return new ResponseEntity<>(BusDto.valueOf(busService.removeBusByCode(code)), HttpStatus.OK);
    }


}
