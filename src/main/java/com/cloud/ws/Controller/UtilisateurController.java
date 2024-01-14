package com.cloud.ws.Controller;

import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.UtilisateurRepository;
import com.cloud.ws.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService= utilisateurService;
    }

    @PostMapping("/utilisateur")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Utilisateur saveUtilisateur(@RequestParam String nom,@RequestParam String prenoms,@RequestParam String ddn,@RequestParam int sexe,@RequestParam String email,@RequestParam String password,@RequestParam String adresse,@RequestParam String tel,@RequestParam int isAdmin){
        return utilisateurService.saveUtilisateur(nom,prenoms,ddn,sexe,email,password,adresse,tel,isAdmin);
    }
}
