package com.cloud.ws.Controller;

import com.cloud.ws.Model.*;
import com.cloud.ws.Service.AnneeModeleService;
import com.cloud.ws.Service.ModeleService;
import com.cloud.ws.Service.MoteurModeleService;
import com.cloud.ws.Service.MoteurService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AnneeModeleController {
    private final AnneeModeleService anneeModeleService;
    private final ModeleService modeleService;



    public AnneeModeleController(AnneeModeleService anneeModeleService, ModeleService modeleService, MoteurService moteurService){
        this.anneeModeleService = anneeModeleService;
        this.modeleService= modeleService;
    }

    @PostMapping("/anneeModele")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public AnneeModele saveMoteurModele(@RequestParam String annee, @RequestParam int idModele){
        Modele modele= modeleService.getModeleById(idModele);
        return anneeModeleService.saveAnneeModele(annee,modele);
    }

    @GetMapping("/anneeModeles")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<AnneeModele> getMoteurModeleByModele(@RequestParam int idModele){
        return anneeModeleService.getAllByModele(idModele);
    }

}
