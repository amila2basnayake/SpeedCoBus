package com.abccompany.speedcobussystem.model;

import com.abccompany.speedcobussystem.model.dto.StopDto;

import javax.persistence.*;

@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public static Stop valueOf(StopDto stopDto) {
        Stop stop = new Stop();
        stop.setId(stopDto.getId());
        stop.setCode(stopDto.getCode());
        if (stopDto.getRouteDtos() != null) {
            stop.setRoute(Route.valueOf(stopDto.getRouteDtos()));
        }
        return stop;
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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}