package com.abccompany.speedcobussystem.model;

import com.abccompany.speedcobussystem.model.dto.BusDto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Schedule> schedules = new ArrayList<>();


    public static Bus valueOf(BusDto busDto) {
        Bus bus = new Bus();
        bus.setId(busDto.getId());
        bus.setCode(busDto.getCode());
        if (busDto.getScheduleDtos() != null && !busDto.getScheduleDtos().isEmpty()) {
            bus.setSchedules(busDto.getScheduleDtos().stream().map(Schedule::valueOf).collect(Collectors.toList()));
        }
        return bus;
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}