package com.cloud.ws.Controller;


import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Service.AnnonceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnonceController {

    AnnonceService annonceService;
    /*------------CRUD---------------*/

    //All annonce
    @GetMapping("/Annonces")
    public Iterable<Annonce> getAll(){
        return annonceService.getAll();
    }

    //Annonce en demande de validation
    @GetMapping("/AnnoncesEnDemande")
    public Iterable<Annonce> getAllAnnonceDemande(){
        return annonceService.getAnnonceEnDemande();
    }

    //Annonce mbola dispo
    @GetMapping("/AnnoncesDispo")
    public Iterable<Annonce> getAllAnnonceDispo(){
        return annonceService.getAnnonceDispo();
    }

    //Historique annonces pour client specifique
    @GetMapping("/AnnoncesHistorique")
    public Iterable<Annonce> getAnnonceClientHistorique(@RequestParam int idClient){
        return annonceService.getAnnonceClientHistorique(idClient);
    }

    //Annonces favoris client
    @GetMapping("/AnnoncesFavoris")
    public Iterable<Annonce> getAnnonceFavorisClient(@RequestParam int idClient){
        return annonceService.getAnnonceFavorisClient(idClient);
    }
    /*------------Statistiques--------------*/

    //Nombre annonce ao amin 'ny année iray par mois
    @GetMapping("/Annonce/statNbAnnonceAnnee")
    public int[] getStatNbAnnonceParAnnee(@RequestParam int annee){
        return annonceService.nbAnnonceMoisAnnee(annee);
    }

    //Nombre annonce par jour hoan année sy mois donné
    @GetMapping("/Annonce/statNbAnnonceAnneeMois")
    public int[] getStatNbAnnonceParAnneeParMois(@RequestParam int annee,@RequestParam int mois){
        return annonceService.nbAnnonceMoisAnneeJours(mois,annee);
    }

    //Nombre voiture vendu ao amin 'ny année iray par mois
    @GetMapping("/statNbVoitureVenduAnnee")
    public int[] getStatNbVoitureVenduParAnnee(@RequestParam int annee){
        return annonceService.nbVoitureVenduMoisAnnee(annee);
    }
    //Nombre voiture vendu par jour hoan année sy mois donné
    @GetMapping("/statNbVoitureVenduAnneeMois")
    public int[] getStatNbVoitureVenduParAnneeParMois(@RequestParam int annee,@RequestParam int mois){
        return annonceService.nbVoitureVenduMoisAnneeJours(mois,annee);
    }





}
