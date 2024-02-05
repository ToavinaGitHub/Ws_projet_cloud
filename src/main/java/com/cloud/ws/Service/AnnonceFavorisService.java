package com.cloud.ws.Service;

import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Model.AnnonceFavoris;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Repository.AnnonceFavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class AnnonceFavorisService {
    @Autowired
    AnnonceFavorisRepository  annonceFavorisRepository;

    public Vector<AnnonceFavoris> getAll(){
        return (Vector<AnnonceFavoris>) annonceFavorisRepository.findAll();
    }

    public void save(AnnonceFavoris a){
        annonceFavorisRepository.save(a);

    }

    public AnnonceFavoris getById(int id){
        return annonceFavorisRepository.findAnnonceFavorisByIdAnnonceFavoris(id);
    }

    public void deleteAnnonceFavorie(AnnonceFavoris a){
        annonceFavorisRepository.delete(a);
    }

}
