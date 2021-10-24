package com.abccompany.speedcobussystem.repository;

import com.abccompany.speedcobussystem.model.Schedule;
import com.abccompany.speedcobussystem.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}
