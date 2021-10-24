package com.abccompany.speedcobussystem.model.dto;

import com.abccompany.speedcobussystem.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusDto {

    private Long id;
    private String code;
    private List<ScheduleDto> scheduleDtos = new ArrayList<>();

    public static BusDto valueOf(Bus bus) {
        BusDto busDto = new BusDto();
        busDto.setId(bus.getId());
        busDto.setCode(bus.getCode());
        if (bus.getSchedules() != null && !bus.getSchedules().isEmpty()) {
            busDto.setScheduleDtos(bus.getSchedules().stream().map(ScheduleDto::valueOf).collect(Collectors.toList()));
        }
        return busDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ScheduleDto> getScheduleDtos() {
        return scheduleDtos;
    }

    public void setScheduleDtos(List<ScheduleDto> scheduleDtos) {
        this.scheduleDtos = scheduleDtos;
    }
}