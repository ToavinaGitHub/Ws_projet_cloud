package com.cloud.ws.Repository;

import com.cloud.ws.Model.AnneeModele;
import com.cloud.ws.Model.MoteurModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnneeModeleRepository extends JpaRepository<AnneeModele,Integer> {

    @Query("SELECT annee from AnneeModele annee where annee.modele.idModele= ?1 and annee.modele.etat=0")
    public List<AnneeModele> findAnneeModeleByModele(int idModele);
}
