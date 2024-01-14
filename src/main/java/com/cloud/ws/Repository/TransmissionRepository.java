package com.cloud.ws.Repository;


import com.cloud.ws.Model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
    @Query("SELECT transmission from Transmission transmission where transmission.etat=0")
    public List<Transmission> getAllTransmission();

    public Transmission findByIdTransmission(int id);
}
