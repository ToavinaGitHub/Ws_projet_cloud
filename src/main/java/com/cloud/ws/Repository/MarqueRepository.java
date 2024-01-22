package com.cloud.ws.Repository;


import com.cloud.ws.Model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
    @Query("SELECT marque from Marque marque where marque.etat=0")
    public List<Marque> getAllMarque();

    public Marque findByIdMarque(int id);
}
