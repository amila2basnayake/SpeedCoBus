package com.abccompany.speedcobussystem.controller;

import com.abccompany.speedcobussystem.model.Line;
import com.abccompany.speedcobussystem.model.dto.LineDto;
import com.abccompany.speedcobussystem.service.LineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> addLine(@RequestBody final LineDto lineDto) {
        if(lineDto.getName()==null){
            return new ResponseEntity<String>("Line name does not Exist.",HttpStatus.BAD_REQUEST);
        }

        if( lineService.searchLineByName(lineDto.getName())==null || !lineDto.getName().equals(lineService.searchLineByName(lineDto.getName()).getName())){
            Line line = Line.valueOf(lineDto);
            return new ResponseEntity<>(LineDto.valueOf(
                    lineService.createLine(line)), HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Line name already Exist.",HttpStatus.CONFLICT);
    }


    /**
     * Search Line by id or name
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchLine(@RequestBody final LineDto lineDto) {
        if(lineDto.getName()!=null || lineDto.getId()!=null) {
            Line line = Line.valueOf(lineDto);
            List<LineDto> lineDtoList = lineService.searchLineByNameAndId(line).stream().map(LineDto::valueOf).collect(Collectors.toList());
            return new ResponseEntity<List<LineDto>>(lineDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Please check the Parameter ", HttpStatus.NOT_FOUND);
    }

    /**
     * Remove Bus Line
     *
     */
    @DeleteMapping("/{name}")
    public ResponseEntity<?> removeLine(@PathVariable("name") final String name) {
        if(name!=null && lineService.searchLineByName(name) !=null) {
            return new ResponseEntity<>(LineDto.valueOf(lineService.removeLineByName(name)), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Line does not found ", HttpStatus.NOT_FOUND);
    }

}
