package com.cloud.ws.Controller;


import com.cloud.ws.Model.*;
import com.cloud.ws.Repository.*;
import com.cloud.ws.Service.AnnonceFavorisService;
import com.cloud.ws.Service.AnnonceService;
import com.cloud.ws.Service.CommissionService;
import com.cloud.ws.Service.SaryAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http .ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
            AnnonceRepository annonceRepository;

    AnnonceService annonceService;

    SaryAnnonceService saryAnnonceService;

    AnnonceFavorisService annonceFavorisService;

    CommissionService commissionService;

    @Autowired
    public AnnonceController(AnnonceService annonceService ,SaryAnnonceService saryAnnonceService,AnnonceFavorisService annonceFavorisService,CommissionService commissionService) {
        this.annonceService = annonceService;
        this.saryAnnonceService = saryAnnonceService;
        this.annonceFavorisService = annonceFavorisService;
        this.commissionService = commissionService;
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

    @GetMapping("/NbAnnoncesEnDemande")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public int getNbAnnonceDemande(){
        return annonceService.nombreAnnonceEnDemande();
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


    //tous les annonces d'un client
    @GetMapping("/annoncesUser")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Iterable<Annonce> getAnnonceUser(@RequestParam int idClient){

        Utilisateur u = utilisateurRepository.findUtilisateurByIdUtilisateur(idClient);
        return annonceService.getByUser(u);
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

    @GetMapping("/bestMarqueCount")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Integer> getBestMarqueCount(@RequestParam int annee){
        return annonceService.bestSoldesCount(annee);
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

    @PostMapping(value = "/Annonce/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> save(@RequestPart("a") Annonce a , @RequestPart("file") List<MultipartFile> files){

        a.setCommission(commissionService.getCommissionActuel());
        annonceService.save(a);

        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();
                String base64Image = Base64Utils.encodeToString(bytes);
                SaryAnnonce temp = new SaryAnnonce();
                temp.setSary(base64Image);
                temp.setAnnonce(a);

                saryAnnonceService.save(temp);
                // Do something with the base64Image (e.g., save it, etc.)
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Error processing files");
            }
        }
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


    /*------------------Mettre annonce en favoris----------------------*/


    @PostMapping("annonceFavoris/save")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> annonceToFavoris(@RequestParam int idUser,@RequestParam int idAnnonce){
        AnnonceFavoris an = new AnnonceFavoris();
        Utilisateur u = utilisateurRepository.findUtilisateurByIdUtilisateur(idUser);
        Annonce a = annonceRepository.findAnnonceByIdAnnonce(idAnnonce);

        an.setUtilisateur(u);
        an.setAnnonce(a);

        annonceFavorisService.save(an);

        return ResponseEntity.ok("Annonce mis en favori");
    }

    /*-------Recherche multiple-------*/

    @GetMapping("/Annonces/search")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Annonce> rechercheMulti(@RequestBody RechercheMultiple rechercheMultiple){
        return annonceService.searchAnnonces(rechercheMultiple);
    }

    @GetMapping("/Annonce")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Annonce details(@RequestParam int idAnnonce){
        return annonceService.getById(idAnnonce);
    }
}

