package com.abccompany.speedcobussystem.model;


import com.abccompany.speedcobussystem.model.dto.RouteDto;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;

    @OneToMany(mappedBy = "route")
    private List<Stop> stops;

    public static Route valueOf(RouteDto routeDto) {
        Route route = new Route();
        route.setId(routeDto.getId());
        route.setName(routeDto.getName());
        if (routeDto.getStopDtos() != null && !routeDto.getStopDtos().isEmpty()) {
            route.setStops(routeDto.getStopDtos().stream().map(Stop::valueOf).collect(Collectors.toList()));
        }
        if(routeDto.getLineDtos()!=null) {
            route.setLine(Line.valueOf(routeDto.getLineDtos()));
        }
        return route;
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

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public void addStop(Stop stop) {
        stops.add(stop);
    }

    public void removeStop(Stop stop) {
        stops.remove(stop);
    }


}