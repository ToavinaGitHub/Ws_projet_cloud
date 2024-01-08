package com.cloud.ws.Repository;

import ch.qos.logback.core.net.server.Client;
import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Vector;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {

    public Annonce findAnnonceByIdAnnonce(int idAnnonce);
    public Vector<Annonce> findAnnonceByEtat(int idEtat);
    public Vector<Annonce> findAnnonceByUtilisateurAndEtat(Utilisateur u,int etat);

    /*---------------Statistique-------------------*/

    //Nombre d'annonce par mois par année
    @Query("SELECT COUNT(a) FROM Annonce a WHERE MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    int countByMoisAndAnnee(@Param("mois") int mois, @Param("annee") int annee);

    //Nombre de voiture vendu par mois par ans
    @Query("SELECT COUNT(a) FROM Annonce a WHERE a.etat=10 AND MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public int voitureVenduParMoisParAnnee(@Param("mois") int mois, @Param("annee") int annee);

    //Prix moyenne voiture vendu par mois par ans
    @Query("SELECT AVG(a.prixVente) FROM Annonce a WHERE a.etat=10 and MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public double prixMoyenneVenduParMoisParAnnee(@Param("mois") int mois, @Param("annee") int annee);

    //Nombre moyenne d'annonce par jour par mois par ans
    @Query("SELECT (AVG(count (a))) FROM Annonce a WHERE a.etat=10 and MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public double nbMoyenneAnnonceJourMoisAnnee(@Param("mois") int mois, @Param("annee") int annee);

    //Meilleur vente Marque vehicule
    @Query("SELECT a.modele.marque,count(a) as isany FROM Annonce a WHERE a.etat=10 GROUP BY a.modele.marque.idMarque ORDER by isany")
    public Marque getBestMarquVendu();

    //Nombre de vehicule par marque par mois par ans
    @Query("SELECT count(a) FROM Annonce a WHERE MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee and a.modele.marque.idMarque= :idMarque")
    public int nbMarqueVehiculeParMoisParAnnee(@Param("mois") int mois,@Param("annee") int annee,@Param("idMarque") int idMarque);

}
