package com.cloud.ws.Repository;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarburantRepository extends JpaRepository<Carburant, Long> {
    @Query("SELECT carburant from Carburant carburant where carburant.etat=0")
    public List<Carburant> getAllCaburant();

    public Carburant findByIdCarburant(int id);
}
