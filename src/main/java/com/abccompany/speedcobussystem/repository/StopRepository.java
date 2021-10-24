package com.abccompany.speedcobussystem.repository;

import com.abccompany.speedcobussystem.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop,Long> {
    public Stop findStopByCode(String code);
}
