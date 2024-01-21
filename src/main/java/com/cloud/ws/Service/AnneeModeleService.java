package com.cloud.ws.Service;


import com.cloud.ws.Model.AnneeModele;
import com.cloud.ws.Model.Modele;
import com.cloud.ws.Model.Moteur;
import com.cloud.ws.Model.MoteurModele;
import com.cloud.ws.Repository.AnneeModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeModeleService {

    @Autowired
    AnneeModeleRepository anneeModeleRepository;

    public AnneeModele saveAnneeModele(String annee, Modele modele){

        AnneeModele an = new AnneeModele();
        an.setAnnee(annee);
        an.setModele(modele);

        anneeModeleRepository.save(an);
        return an;
    }

    public List<AnneeModele> getAllByModele(int idModele){
        return anneeModeleRepository.findAnneeModeleByModele(idModele);
    }
}
