package com.cloud.ws.Service;

import com.cloud.ws.Model.Modele;
import com.cloud.ws.Model.Moteur;
import com.cloud.ws.Model.MoteurModele;
import com.cloud.ws.Repository.MoteurModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoteurModeleService {
    private final MoteurModeleRepository moteurModeleRepository;

    @Autowired
    public MoteurModeleService(MoteurModeleRepository moteurModeleRepository){
        this.moteurModeleRepository=moteurModeleRepository;
    }

    public MoteurModele saveMoteurModele(Moteur moteur,Modele modele){
        MoteurModele moteurModele= new MoteurModele();
        moteurModele.setMoteur(moteur);
        moteurModele.setModele(modele);
        moteurModele= moteurModeleRepository.save(moteurModele);
        return moteurModele;
    }

    public List<MoteurModele> getAllByModele(int idModele){
        return moteurModeleRepository.findMoteurModeleByModele(idModele);
    }
}
