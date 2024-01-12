package com.cloud.ws.Repository;

import com.cloud.ws.Model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission,Integer> {
}
