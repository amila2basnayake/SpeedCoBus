package com.abccompany.speedcobussystem.service;

import com.abccompany.speedcobussystem.model.Schedule;
import com.abccompany.speedcobussystem.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule timeSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
