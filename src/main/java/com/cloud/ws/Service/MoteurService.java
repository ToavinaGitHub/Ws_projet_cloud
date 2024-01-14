package com.cloud.ws.Service;

import com.cloud.ws.Model.Modele;
import com.cloud.ws.Model.Moteur;
import com.cloud.ws.Repository.MoteurModeleRepository;
import com.cloud.ws.Repository.MoteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoteurService {
    private final MoteurRepository moteurRepository;

    @Autowired
    public MoteurService(MoteurRepository moteurRepository){
        this.moteurRepository= moteurRepository;
    }
    public Moteur saveMoteur(String nom){
        Moteur moteur= new Moteur();
        moteur.setNomMoteur(nom);
        return moteurRepository.save(moteur);
    }

    public List<Moteur> getAllMoteur() {
        return moteurRepository.getAllMoteur();
    }

    public Moteur getMoteurById(int id){
        return moteurRepository.findByIdMoteur(id);
    }

    public void deleteMoteur(Moteur moteur){
        moteur.setEtat(1);
        moteurRepository.save(moteur);
    }

    public Moteur updateMoteur(Moteur moteur, String nom){
        moteur.setNomMoteur(nom);
        return moteurRepository.save(moteur);
    }

}
