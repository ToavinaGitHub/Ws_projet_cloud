package com.cloud.ws.Repository;

import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.AnnonceFavoris;
import com.cloud.ws.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Vector;

public interface AnnonceFavorisRepository extends JpaRepository<AnnonceFavoris,Integer> {

    @Query("SELECT a.annonce FROM AnnonceFavoris a WHERE a.utilisateur.idUtilisateur=?1 ")
    public Vector<Annonce> getByUtilisateur(int idUtilisateur);

    public AnnonceFavoris findAnnonceFavorisByIdAnnonceFavoris(int id);

    public AnnonceFavoris findAnnonceFavorisByUtilisateurAndAndAnnonce(Utilisateur u,Annonce a);

}
