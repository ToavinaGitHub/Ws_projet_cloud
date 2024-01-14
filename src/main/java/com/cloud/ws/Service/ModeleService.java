package com.cloud.ws.Service;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Modele;
import com.cloud.ws.Repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleService {

    public final ModeleRepository modeleRepository;

    @Autowired
    public ModeleService(ModeleRepository modeleRepository){
        this.modeleRepository= modeleRepository;
    }

    public Modele saveModele(String nom, Categorie categorie, Marque marque){
        Modele modele= new Modele();
        modele.setNomModele(nom);
        modele.setCategorie(categorie);
        modele.setMarque(marque);
        modele= modeleRepository.save(modele);
        return modele;
    }

    public List<Modele> getModelesByMarque(int idMarque){
        List<Modele> modeles= modeleRepository.getModelesByMarque(idMarque);
        return modeles;
    }

    public Modele getModeleById(int idModele){
        Modele modele= modeleRepository.getModeleByIdModele(idModele);
        return modele;
    }

    public void deleteModele(Modele modele){
        modele.setEtat(1);
        modeleRepository.save(modele);
    }

    public Modele updateModele(Modele modele, String nom){
        modele.setNomModele(nom);
        return modeleRepository.save(modele);
    }
}
