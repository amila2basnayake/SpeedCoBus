package com.abccompany.speedcobussystem.model.dto;
import com.abccompany.speedcobussystem.model.Stop;

public class StopDto {

    private Long id;
    private String code;
    private RouteDto routeDtos;

    public static StopDto valueOf(Stop stop) {
        StopDto stopDto = new StopDto();
        stopDto.setId(stop.getId());
        stopDto.setCode(stop.getCode());
        if (stop.getRoute() != null) {
            stopDto.setRouteDtos(RouteDto.valueOf(stop.getRoute()));
        }
        return stopDto;
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

    public RouteDto getRouteDtos() {
        return routeDtos;
    }

    public void setRouteDtos(RouteDto routeDtos) {
        this.routeDtos = routeDtos;
    }
}