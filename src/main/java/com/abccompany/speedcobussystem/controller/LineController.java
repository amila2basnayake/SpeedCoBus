package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Bus;
import com.abccompany.speedcobussystem.model.Line;
import com.abccompany.speedcobussystem.model.dto.BusDto;
import com.abccompany.speedcobussystem.model.dto.LineDto;
import com.abccompany.speedcobussystem.model.dto.StopDto;
import com.abccompany.speedcobussystem.service.LineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/line")
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    /**
     * Add Bus Line
     *
     */
    @PostMapping
    public ResponseEntity<LineDto> addLine(@RequestBody final LineDto lineDto) {
        Line line = Line.valueOf(lineDto);
        // TODO:code should validate can be multiple
        return new ResponseEntity<>(LineDto.valueOf(
                lineService.createLine(line)), HttpStatus.CREATED);
    }

    /**
     * Remove Bus Line
     *
     */
    @DeleteMapping("/{name}")
    public ResponseEntity<LineDto> removeLine(@PathVariable("name") final String name) {
        return new ResponseEntity<>(LineDto.valueOf(lineService.removeLineByName(name)), HttpStatus.OK);
    }


}
