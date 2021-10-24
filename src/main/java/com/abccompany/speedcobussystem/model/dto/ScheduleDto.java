package com.abccompany.speedcobussystem.model.dto;
import com.abccompany.speedcobussystem.model.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


public class ScheduleDto {
    private Long id;
    private BusDto busDto;
    private LineDto lineDto;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDateTime;

    public static ScheduleDto valueOf(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setStartDateTime(schedule.getStartDateTime());
        scheduleDto.setBusDto(BusDto.valueOf(schedule.getBus()));
        scheduleDto.setLineDto(LineDto.valueOf(schedule.getLine()));
        return scheduleDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusDto getBusDto() {
        return busDto;
    }

    public void setBusDto(BusDto busDto) {
        this.busDto = busDto;
    }


    public LineDto getLineDto() {
        return lineDto;
    }

    public void setLineDto(LineDto lineDto) {
        this.lineDto = lineDto;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }
}