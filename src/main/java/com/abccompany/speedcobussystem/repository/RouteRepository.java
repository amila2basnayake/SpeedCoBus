package com.abccompany.speedcobussystem.repository;



import com.abccompany.speedcobussystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository <Route,Long>{
    public Route findRouteByName(String name);
}
