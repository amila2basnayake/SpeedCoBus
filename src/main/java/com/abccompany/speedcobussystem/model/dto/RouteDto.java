package com.abccompany.speedcobussystem.model.dto;

import com.abccompany.speedcobussystem.model.Route;
import java.util.List;
import java.util.stream.Collectors;

public class RouteDto {
    private Long id;
    private String name;
    private LineDto lineDtos;
    private List<StopDto> stopDtos;

    public static RouteDto valueOf(Route route) {
        RouteDto routeDto = new RouteDto();
        routeDto.setId(route.getId());
        routeDto.setName(route.getName());
        if(route.getLine()!=null) {
            routeDto.setLineDtos(LineDto.valueOf(route.getLine()));
        }
        return routeDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StopDto> getStopDtos() {
        return stopDtos;
    }

    public void setStopDtos(List<StopDto> stopDtos) {
        this.stopDtos = stopDtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LineDto getLineDtos() {
        return lineDtos;
    }

    public void setLineDtos(LineDto lineDtos) {
        this.lineDtos = lineDtos;
    }
}