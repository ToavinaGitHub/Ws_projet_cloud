package com.cloud.ws.Controller;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService){
        this.categorieService= categorieService;
    }

    @PostMapping("/categorie")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Categorie saveCategorie(@RequestParam String nom){
        return categorieService.saveCategorie(nom);
    }

    @GetMapping("/categories")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategorie();
    }

    @DeleteMapping("/categorie/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteCategorie(@PathVariable int id){
        Categorie categorie= categorieService.getById(id);
        categorieService.deleteCategorie(categorie);
    }

    @PutMapping("/categorie/{id}")
    public Categorie updateCategorie(@PathVariable int id,String nom){
        Categorie categorie= categorieService.getById(id);
        return categorieService.updateCategorie(categorie,nom);
    }
}
