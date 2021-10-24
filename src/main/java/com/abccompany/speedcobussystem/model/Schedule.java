package com.abccompany.speedcobussystem.model;


import com.abccompany.speedcobussystem.model.dto.ScheduleDto;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "line_id")
    private Line line;

    private Date startDateTime;

    public static Schedule valueOf(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDto.getId());
        schedule.setStartDateTime(scheduleDto.getStartDateTime());
        schedule.setBus(Bus.valueOf(scheduleDto.getBusDto()));
        schedule.setLine(Line.valueOf(scheduleDto.getLineDto()));
        return schedule;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }
}
