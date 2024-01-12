package com.cloud.ws.Repository;

import com.cloud.ws.Model.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepository extends JpaRepository<Carburant,Integer> {
}
