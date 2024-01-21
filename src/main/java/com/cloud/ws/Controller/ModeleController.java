package com.cloud.ws.Controller;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Modele;
import com.cloud.ws.Service.CategorieService;
import com.cloud.ws.Service.MarqueService;
import com.cloud.ws.Service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModeleController {
    private final ModeleService modeleService;
    private final CategorieService categorieService;

    private final MarqueService marqueService;

    @Autowired
    public ModeleController(ModeleService modeleService, CategorieService categorieService, MarqueService marqueService){
        this.modeleService= modeleService;
        this.categorieService= categorieService;
        this.marqueService= marqueService;
    }

    @PostMapping("/modele")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Modele saveModele(@RequestParam String nom, @RequestParam int idCategorie, @RequestParam int idMarque){
        Categorie categorie= categorieService.getById(idCategorie);
        Marque marque= marqueService.getById(idMarque);
        Modele modele= modeleService.saveModele(nom,categorie,marque);
        return modele;
    }
    @GetMapping("/modeles")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Modele> saveModele(){
        return modeleService.getAll();
    }

    @GetMapping("/modeles/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Modele> modelesByMarque(@PathVariable int id){
        List<Modele> modeles= modeleService.getModelesByMarque(id);
        return modeles;
    }

    @DeleteMapping("/modele/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteModele(@PathVariable int id){
        Modele modele= modeleService.getModeleById(id);
        modeleService.deleteModele(modele);
    }

    @PutMapping("/modele/{id}")
    public Modele updateModele(@PathVariable int id,String nom){
        Modele modele= modeleService.getModeleById(id);
        return modeleService.updateModele(modele,nom);
    }
}
