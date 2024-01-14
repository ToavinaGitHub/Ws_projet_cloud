package com.cloud.ws.Repository;
import com.cloud.ws.Model.Moteur;
import com.cloud.ws.Model.MoteurModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MoteurModeleRepository extends JpaRepository<MoteurModele, Long> {

    @Query("SELECT moteurModele from MoteurModele moteurModele where moteurModele.modele.idModele= :idModele and moteurModele.modele.etat=0 and moteurModele.etat=0")
    public List<MoteurModele> findMoteurModeleByModele(int idModele);
}
