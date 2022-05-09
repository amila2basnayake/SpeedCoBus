package com.abccompany.speedcobussystem.model;

import com.abccompany.speedcobussystem.model.dto.LineDto;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "line")
    private List<Route> routes;

    @OneToMany(mappedBy = "line", cascade = CascadeType.ALL)
    private List<Schedule> schedules = new ArrayList<>();

    public Line(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Line() {

    }

    public Line(String name) {
        this.name = name;
    }

    public static Line valueOf(LineDto lineDto) {
        Line line = new Line();
        line.setId(lineDto.getId());
        line.setName(lineDto.getName());
        if (lineDto.getRouteDtos() != null && !lineDto.getRouteDtos().isEmpty()) {
            line.setRoutes(lineDto.getRouteDtos().stream().map(Route::valueOf).collect(Collectors.toList()));
        }
        if (lineDto.getScheduleDtos() != null && !lineDto.getScheduleDtos().isEmpty()) {
            line.setSchedules(lineDto.getScheduleDtos().stream().map(Schedule::valueOf).collect(Collectors.toList()));
        }
        return line;
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

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return id.equals(line.id) && name.equals(line.name) && Objects.equals(routes, line.routes) && Objects.equals(schedules, line.schedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, routes, schedules);
    }
}