package com.abccompany.speedcobussystem.controller;


import com.abccompany.speedcobussystem.model.Schedule;
import com.abccompany.speedcobussystem.model.dto.BusDto;
import com.abccompany.speedcobussystem.model.dto.ScheduleDto;
import com.abccompany.speedcobussystem.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     *   Scheduling lines to a bus for a given time
     *
     */
    @PostMapping
    public ResponseEntity<ScheduleDto> timeSchedule(@RequestBody final ScheduleDto scheduleDto) {
        Schedule schedule = Schedule.valueOf(scheduleDto);
        return new ResponseEntity<>(ScheduleDto.valueOf(
                scheduleService.timeSchedule(schedule)), HttpStatus.CREATED);
    }

}
