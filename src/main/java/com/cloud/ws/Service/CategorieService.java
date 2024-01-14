package com.cloud.ws.Service;


import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository){
        this.categorieRepository= categorieRepository;
    }

    public Categorie saveCategorie(String nom){
        Categorie categorie= new Categorie();
        categorie.setNomCategorie(nom);
        categorie= categorieRepository.save(categorie);
        return categorie;
    }

    public List<Categorie> getAllCategorie(){
        return categorieRepository.getAllCategorie();
    }

    public Categorie getById(int id){
        Categorie categorie= new Categorie();
        categorie= categorieRepository.findByIdCategorie(id);
        return categorie;
    }
    public void deleteCategorie(Categorie categorie){
        categorie.setEtat(1);
        categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Categorie categorie, String nom){
        categorie.setNomCategorie(nom);
        return  categorieRepository.save(categorie);
    }
}
