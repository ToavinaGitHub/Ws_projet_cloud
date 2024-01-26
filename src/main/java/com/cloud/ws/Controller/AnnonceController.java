package com.cloud.ws.Controller;


import com.cloud.ws.Model.*;
import com.cloud.ws.Repository.*;
import com.cloud.ws.Service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnonceController {

    @Autowired
    TransmissionRepository transmissionRepository;

    @Autowired
    MarqueRepository marqueRepository;

    @Autowired
    MoteurRepository moteurRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    CarburantRepository carburantRepository;

    AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }
    /*------------CRUD---------------*/
    //All annonce
    @GetMapping("/Annonces")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Annonce> getAll(){
        return annonceService.getAll();
    }
    //Annonce en demande de validation
    @GetMapping("/AnnoncesEnDemande")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Annonce> getAllAnnonceDemande(){
        return annonceService.getAnnonceEnDemande();
    }

    //Annonce mbola dispo
    @GetMapping("/AnnoncesDispo")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Annonce> getAllAnnonceDispo(){
        return annonceService.getAnnonceDispo();
    }

    //Historique annonces pour client specifique
    @GetMapping("/AnnoncesHistorique")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Annonce> getAnnonceClientHistorique(@RequestParam int idClient){
        return annonceService.getAnnonceClientHistorique(idClient);
    }

    //Annonces favoris client
    @GetMapping("/AnnoncesFavoris")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Annonce> getAnnonceFavorisClient(@RequestParam int idClient){
        return annonceService.getAnnonceFavorisClient(idClient);
    }
    /*------------Statistiques--------------*/

    //Nombre annonce ao amin 'ny année iray par mois
    @GetMapping("/Annonce/statNbAnnonceAnnee")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public int[] getStatNbAnnonceParAnnee(@RequestParam int annee){
        return annonceService.nbAnnonceMoisAnnee(annee);
    }

    //Nombre annonce par jour hoan année sy mois donné
    @GetMapping("/Annonce/statNbAnnonceAnneeMois")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public int[] getStatNbAnnonceParAnneeParMois(@RequestParam int annee,@RequestParam int mois){
        return annonceService.nbAnnonceMoisAnneeJours(mois,annee);
    }

    //Nombre voiture vendu ao amin 'ny année iray par mois
    @GetMapping("/statNbVoitureVenduAnnee")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public int[] getStatNbVoitureVenduParAnnee(@RequestParam int annee){
        return annonceService.nbVoitureVenduMoisAnnee(annee);
    }
    //Nombre voiture vendu ao amin 'ny année iray par mois
    @GetMapping("/statNbVoitureMarqueVenduAnnee")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public int[] getStatNbVoitureVenduMarqueParAnnee(@RequestParam int idMarque ,@RequestParam int annee){
        return annonceService.nbVoitureMarqueVenduMoisAnnee(idMarque,annee);
    }

    //Nombre voiture vendu ao amin 'ny année iray par mois
    @GetMapping("/bestMarque")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<String> getBestMarque(@RequestParam int annee){
        return annonceService.bestSoldes(annee);
    }
    //Nombre voiture vendu par jour hoan année sy mois donné
    @GetMapping("/statNbVoiturmeVenduAnneeMois")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public int[] getStatNbVoitureVenduParAnneeParMois(@RequestParam int annee,@RequestParam int mois){
        return annonceService.nbVoitureVenduMoisAnneeJours(mois,annee);
    }

    //Prix par mois
    @GetMapping("/statPrixMois")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Double[] getStatPrixMois(@RequestParam int annee){
        return annonceService.prixParMois(annee);
    }

    @GetMapping("/revenuAnnuel")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Double prixParAns(@RequestParam int annee){

        if( annonceService.revenuAnnuel(annee)!=null){
            return annonceService.revenuAnnuel(annee);
        }
        return 0.0;
    }

    @PostMapping("/Annonce/save")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> save(@RequestBody Annonce a){
        annonceService.save(a);
        return ResponseEntity.ok("Annonce inséré avec succes");
    }


        @PostMapping("/Annonce/validation")
        @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> validerAnnonce(@RequestParam int idAnnonce){
        annonceService.ValiderAnnonce(idAnnonce);
        return ResponseEntity.ok("Valider avec succes*");
    }

    @PostMapping("/Annonce/refuser")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> refuserAnnonce(@RequestParam int idAnnonce){
        annonceService.RefuserAnnonce(idAnnonce);
        return ResponseEntity.ok("Refuser avec succes");
    }

    @PostMapping("/Annonce/toVendu")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> annonceToVendu(@RequestParam int idAnnonce){
        annonceService.AnnonceToVendu(idAnnonce);
        return ResponseEntity.ok("Annonce vendu avec succes");
    }
}
