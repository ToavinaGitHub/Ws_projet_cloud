package com.cloud.ws.Service;

import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.AnnonceFavorisRepository;
import com.cloud.ws.Repository.AnnonceRepository;
import com.cloud.ws.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    AnnonceFavorisRepository annonceFavorisRepository;

    public Vector<Annonce> getAll(){
        return (Vector<Annonce>) annonceRepository.findAll();
    }

    // Maka annonce en cours de demande
    public Vector<Annonce> getAnnonceEnDemande(){
        return annonceRepository.findAnnonceByEtat(0);
    }

    //Maka annonce izay mbola tsy vendu
    public Vector<Annonce> getAnnonceDispo(){
        return annonceRepository.findAnnonceByEtat(5);
    }

    //Maka Annonce par client par Etat
    public Vector<Annonce> getAnnonceClientEtat(int idClient,int etat){
        Utilisateur u = utilisateurRepository.findUtilisateurByIdUtilisateur(idClient);
        return annonceRepository.findAnnonceByUtilisateurAndEtat(u,etat);
    }

    //Izay efa vendu
    public Vector<Annonce> getAnnonceClientHistorique(int idClient){
        return this.getAnnonceClientEtat(idClient,10);
    }

    //Maka ny Annonces favoris par client
    public Vector<Annonce> getAnnonceFavorisClient(int idClient){
        return annonceFavorisRepository.getByUtilisateur(idClient);
    }


    //Modifier Etat Annonce
    public void updateEtatAnnonce(int idAnnonce,double prixVente,int etat){
        Annonce a = annonceRepository.findAnnonceByIdAnnonce(idAnnonce);
        Annonce temp  = new Annonce(idAnnonce,a.getKilometrage(),a.getNbPorte(),a.getDescription(),a.getPrixDemande(),prixVente,etat,a.getDateAnnonce(),a.getCommission(),a.getUtilisateur(),a.getTransmission(),a.getCarburant(),a.getModele());
        annonceRepository.delete(a);
        annonceRepository.save(temp);
    }

    //Valider Annonce
    public void ValiderAnnonce(int idAnnonce){
        this.updateEtatAnnonce(idAnnonce,0,5);
    }



}
