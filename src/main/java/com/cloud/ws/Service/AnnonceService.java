package com.cloud.ws.Service;

import com.cloud.ws.Model.Annonce;
import com.cloud.ws.Repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;


    public Vector<Annonce> getAll(){
        return (Vector<Annonce>) annonceRepository.findAll();
    }

}
