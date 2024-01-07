package com.cloud.ws.Repository;

import ch.qos.logback.core.net.server.Client;
import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Vector;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {

    public Annonce findAnnonceByIdAnnonce(int idAnnonce);
    public Vector<Annonce> findAnnonceByEtat(int idEtat);
    public Vector<Annonce> findAnnonceByUtilisateurAndEtat(Utilisateur u,int etat);
}
