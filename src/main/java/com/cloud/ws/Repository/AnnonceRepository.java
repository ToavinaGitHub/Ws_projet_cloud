package com.cloud.ws.Repository;

import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Utilisateur;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Vector;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {


    public List<Annonce> findAnnonceByUtilisateur(Utilisateur u);
    public Annonce findAnnonceByIdAnnonce(int idAnnonce);
    public List<Annonce> findAnnonceByEtat(int idEtat);
    public List<Annonce> findAnnonceByUtilisateurAndEtat(Utilisateur u,int etat);

    /*---------------Statistique-------------------*/

    //Nombre d'annonce par mois par année
    @Query("SELECT COUNT(a) FROM Annonce a WHERE MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    int countByMoisAndAnnee(@Param("mois") int mois, @Param("annee") int annee);


    //Nombre d'annonce par mois par année par jours
    @Query("SELECT COUNT(a) FROM Annonce a WHERE MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee AND DAY(a.dateAnnonce) = :jour")
    int countByMoisAndAnneeAndJour(@Param("mois") int mois, @Param("annee") int annee , @Param("jour") int jour);


    //Nombre de voiture vendu par mois par ans
    @Query("SELECT COUNT(a) FROM Annonce a WHERE a.etat=10 AND MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public int voitureVenduParMoisParAnnee(@Param("mois") int mois, @Param("annee") int annee);


    @Query("SELECT COUNT(a) FROM Annonce a WHERE a.modele.marque.idMarque= :marque and  a.etat=10 AND MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public int voitureMarqueVenduParMoisParAnnee(@Param("marque") int idMarque ,@Param("mois") int mois, @Param("annee") int annee);


    @Query("SELECT a.modele.marque.nomMarque, COUNT(a) as count FROM Annonce a WHERE a.etat=10 AND MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee GROUP BY a.modele.marque ORDER BY count DESC LIMIT 1")
    public String bestCarSoldes(@Param("mois") int mois, @Param("annee") int annee);

    @Query("SELECT COALESCE(COUNT(a), 0) as count FROM Annonce a WHERE a.etat = 10 AND MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee GROUP BY a.modele.marque ORDER BY count DESC LIMIT 1")
    public Integer bestCarSoldesCount(@Param("mois") int mois, @Param("annee") int annee);


    //Nombre de voiture vendu par mois par ans
    @Query("SELECT COUNT(a) FROM Annonce a WHERE a.etat=10 AND MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee AND DAY(a.dateAnnonce) = :jour")
    public int voitureVenduParMoisParAnneeParJours(@Param("mois") int mois, @Param("annee") int annee , @Param("jour") int jour);


    //Prix voiture vendu par mois par ans
    @Query("SELECT SUM(((a.prixDemande)*c.valeur)/100) FROM Annonce a JOIN Commission  c on a.commission.idCommission = c.idCommission WHERE a.etat=10 and MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public Double prixMoyenneVenduParMoisParAnnee(@Param("mois") int mois, @Param("annee") int annee);


    //Revenu par ans
    @Query("SELECT SUM(((a.prixDemande)*c.valeur)/100) FROM Annonce a JOIN Commission  c on a.commission.idCommission = c.idCommission WHERE a.etat=10 AND YEAR(a.dateAnnonce) = :annee GROUP BY YEAR(a.dateAnnonce)")
    public Double prixParAns( @Param("annee") int annee);


    //Nombre moyenne d'annonce par jour par mois par ans
    @Query("SELECT (AVG(count (a))) FROM Annonce a WHERE a.etat=10 and MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee")
    public double nbMoyenneAnnonceJourMoisAnnee(@Param("mois") int mois, @Param("annee") int annee);

    //Meilleur vente Marque vehicule
    @Query("SELECT a.modele.marque,count(a) as isany FROM Annonce a WHERE a.etat=10 GROUP BY a.modele.marque.idMarque ORDER by isany")
    public Marque getBestMarqueVendu();


    //Nombre de vehicule par marque par mois par ans
    @Query("SELECT count(a) FROM Annonce a WHERE MONTH(a.dateAnnonce) = :mois AND YEAR(a.dateAnnonce) = :annee and a.modele.marque.idMarque= :idMarque")
    public int nbMarqueVehiculeParMoisParAnnee(@Param("mois") int mois,@Param("annee") int annee,@Param("idMarque") int idMarque);


    @Modifying
    @Transactional
    @Query("UPDATE Annonce a SET a.etat = :newState,a.prixVente= :pv WHERE a.idAnnonce = :annonceId ")
    public void updateEtatObjet(@Param("newState") int newState, @Param("annonceId") int annonceId, @Param("pv") double pv);


}
