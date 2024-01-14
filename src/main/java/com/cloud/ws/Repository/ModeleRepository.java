package com.cloud.ws.Repository;

import com.cloud.ws.Model.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele, Long> {

    @Query("SELECT modele from Modele modele where modele.marque.idMarque= :idMarque and modele.marque.etat=0 and modele.etat=0")
    public List<Modele> getModelesByMarque(int idMarque);
    public Modele getModeleByIdModele(int idModele);
}
