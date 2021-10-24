package com.abccompany.speedcobussystem.repository;


import com.abccompany.speedcobussystem.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    public Bus findBusByCode(String code);
}
