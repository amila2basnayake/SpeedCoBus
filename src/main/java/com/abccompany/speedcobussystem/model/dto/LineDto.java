package com.abccompany.speedcobussystem.model.dto;

import com.abccompany.speedcobussystem.model.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LineDto {

    private Long id;
    private String name;
    private List<RouteDto> routeDtos;
    private List<ScheduleDto> scheduleDtos = new ArrayList<>();

    public static LineDto valueOf(Line line) {
        LineDto lineDto = new LineDto();
        lineDto.setId(line.getId());
        lineDto.setName(line.getName());
        if (line.getRoutes() != null && !line.getRoutes().isEmpty()) {
            lineDto.setRouteDtos(line.getRoutes().stream().map(RouteDto::valueOf).collect(Collectors.toList()));
        }
        if (line.getSchedules() != null && !line.getSchedules().isEmpty()) {
            lineDto.setScheduleDtos(line.getSchedules().stream().map(ScheduleDto::valueOf).collect(Collectors.toList()));
        }
        return lineDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RouteDto> getRouteDtos() {
        return routeDtos;
    }

    public void setRouteDtos(List<RouteDto> routeDtos) {
        this.routeDtos = routeDtos;
    }

    public List<ScheduleDto> getScheduleDtos() {
        return scheduleDtos;
    }

    public void setScheduleDtos(List<ScheduleDto> scheduleDtos) {
        this.scheduleDtos = scheduleDtos;
    }
}