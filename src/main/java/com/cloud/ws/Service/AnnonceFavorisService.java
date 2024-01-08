package com.cloud.ws.Service;

import com.cloud.ws.Model.AnnonceFavoris;
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
}
