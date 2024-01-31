package com.cloud.ws.Service;

import com.cloud.ws.Model.Transmission;
import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }

    public Utilisateur saveUtilisateur(String nom, String prenoms, String ddn, int sexe, String email, String password, String adresse, String tel, int isAdmin){
        Utilisateur utilisateur= new Utilisateur(nom,prenoms,ddn,sexe,email,password,adresse,tel,isAdmin);
        utilisateur= utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    public Utilisateur getById(int id){
        return utilisateurRepository.findUtilisateurByIdUtilisateur(id);
    }

}
