package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Bus;
import com.abccompany.speedcobussystem.model.dto.BusDto;
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
     *
     */
    @PostMapping
    public ResponseEntity<?> addBus(@RequestBody final BusDto busDto) {

        if(busDto.getCode()==null){
            return new ResponseEntity<String>("Bus code does not Exist.",HttpStatus.BAD_REQUEST);
        }

        if(busService.findBusByCode(busDto.getCode()) ==null  || !busDto.getCode().equals(busService.findBusByCode(busDto.getCode()).getCode())) {
            Bus bus = Bus.valueOf(busDto);
            return new ResponseEntity<>(BusDto.valueOf(
                    busService.createBus(bus)), HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Bus code already Exist .",HttpStatus.CONFLICT);
    }

    /**
     * Removing buses with their registration (eg: ABC-123)
     *
     */
    @DeleteMapping("{code}")
    public ResponseEntity<?> removeBus(@PathVariable("code") final String code) {

        if(code!=null && busService.findBusByCode(code) !=null) {
            return new ResponseEntity<>(BusDto.valueOf(busService.removeBusByCode(code)), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Bus does not found for given code ", HttpStatus.NOT_FOUND);
    }

    /**
     * Return Bus data (eg: ABC-123)
     *
     */
    @GetMapping("{code}")
    public ResponseEntity<?> listBus(@PathVariable("code") final String code) {

        if(code!=null) {
            return new ResponseEntity<>(BusDto.valueOf(busService.findBusByCode(code)), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Bus does not found for given code ", HttpStatus.NOT_FOUND);
    }


}
