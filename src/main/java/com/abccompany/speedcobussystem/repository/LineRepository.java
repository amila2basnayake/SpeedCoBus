package com.abccompany.speedcobussystem.repository;

import com.abccompany.speedcobussystem.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<Line,Long>, JpaSpecificationExecutor<Line> {
    public Line findLineByName(String name);
}
