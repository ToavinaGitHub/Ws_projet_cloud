package com.cloud.ws.Controller;


import com.cloud.ws.Service.AnnonceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnonceController {


    AnnonceService annonceService;

    /*------------Statistiques--------------*/

    @GetMapping("/statNbAnnonceAnnee")
    public int[] getStatNbAnnonceParAnnee(@RequestParam int annee){
        return annonceService.nbAnnonceMoisAnnee(annee);
    }
    @GetMapping("/statNbAnnonceAnneeMois")
    public int[] getStatNbAnnonceParAnneeParMois(@RequestParam int annee,@RequestParam int mois){
        return annonceService.nbAnnonceMoisAnneeJours(mois,annee);
    }

    @GetMapping("/statNbVoitureVenduAnnee")
    public int[] getStatNbVoitureVenduParAnnee(@RequestParam int annee){
        return annonceService.nbVoitureVenduMoisAnnee(annee);
    }
    @GetMapping("/statNbVoitureVenduAnneeMois")
    public int[] getStatNbVoitureVenduParAnneeParMois(@RequestParam int annee,@RequestParam int mois){
        return annonceService.nbVoitureVenduMoisAnneeJours(mois,annee);
    }

    



}
