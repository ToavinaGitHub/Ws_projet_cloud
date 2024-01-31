package com.cloud.ws.Controller;

import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.UtilisateurRepository;
import com.cloud.ws.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo")
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

    @GetMapping("/hi")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured");
    }

    @GetMapping("/utilisateur")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Utilisateur getById(@RequestParam int id){
        System.out.println("ato");
        return utilisateurService.getById(id);
    }

}
