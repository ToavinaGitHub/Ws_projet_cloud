package com.cloud.ws.Repository;

import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Moteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoteurRepository extends JpaRepository<Moteur, Long> {
    @Query("SELECT moteur from Moteur moteur where moteur.etat=0")
    public List<Moteur> getAllMoteur();

    public Moteur findByIdMoteur(int id);
}
