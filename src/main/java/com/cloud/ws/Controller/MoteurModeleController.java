package com.cloud.ws.Controller;

import com.cloud.ws.Model.Modele;
import com.cloud.ws.Model.Moteur;
import com.cloud.ws.Model.MoteurModele;
import com.cloud.ws.Model.Transmission;
import com.cloud.ws.Service.ModeleService;
import com.cloud.ws.Service.MoteurModeleService;
import com.cloud.ws.Service.MoteurService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MoteurModeleController {
    private final MoteurModeleService moteurModeleService;
    private final ModeleService modeleService;

    private final MoteurService moteurService;


    public MoteurModeleController(MoteurModeleService moteurModeleService, ModeleService modeleService, MoteurService moteurService){
        this.moteurModeleService= moteurModeleService;
        this.modeleService= modeleService;
        this.moteurService= moteurService;
    }

    @PostMapping("/moteurModele")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public MoteurModele saveMoteurModele(@RequestParam int idMoteur, @RequestParam int idModele){
        Modele modele= modeleService.getModeleById(idModele);
        Moteur moteur= moteurService.getMoteurById(idMoteur);
        return moteurModeleService.saveMoteurModele(moteur,modele);
    }

    @GetMapping("/moteurModeles")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<MoteurModele> getMoteurModeleByModele(@RequestParam int idModele){
        return moteurModeleService.getAllByModele(idModele);
    }

}
