package com.cloud.ws.Controller;

import com.cloud.ws.Model.Modele;
import com.cloud.ws.Model.Moteur;
import com.cloud.ws.Model.MoteurModele;
import com.cloud.ws.Repository.MoteurRepository;
import com.cloud.ws.Service.MoteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoteurController {
    private final MoteurService moteurService;

    @Autowired
    public MoteurController(MoteurService moteurService){
        this.moteurService= moteurService;
    }

    @PostMapping("/moteur")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Moteur saveMoteur(@RequestParam String nom){
        return moteurService.saveMoteur(nom);
    }

    @GetMapping ("/moteurs")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Moteur> getAllMoteur(){
        return moteurService.getAllMoteur();
    }

    @DeleteMapping("/moteur/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteMoteur(@PathVariable int id){
        Moteur moteur= moteurService.getMoteurById(id);
        moteurService.deleteMoteur(moteur);
    }

    @PutMapping("/moteur/{id}")
    public Moteur updateMoteur(@PathVariable int id,String nom){
        Moteur moteur= moteurService.getMoteurById(id);
        return moteurService.updateMoteur(moteur,nom);
    }
}
