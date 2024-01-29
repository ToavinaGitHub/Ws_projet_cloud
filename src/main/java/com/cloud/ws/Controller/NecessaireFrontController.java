package com.cloud.ws.Controller;


import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Modele;
import com.cloud.ws.Service.CategorieService;
import com.cloud.ws.Service.MarqueService;
import com.cloud.ws.Service.ModeleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/necessaireFront/")
public class NecessaireFrontController {

    private MarqueService marqueService;
    private ModeleService modeleService;
    private CategorieService categorieService;

    public NecessaireFrontController(MarqueService marqueService, ModeleService modeleService, CategorieService categorieService) {
        this.marqueService = marqueService;
        this.modeleService = modeleService;
        this.categorieService = categorieService;
    }

    @GetMapping("/marques")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Marque> getAllMarque(){
        return marqueService.getAllMarque();
    }

    @GetMapping("/modeles")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Modele> getAllModeles(){
        return modeleService.getAll();
    }

    @GetMapping("/categories")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategorie();
    }






}
