package com.cloud.ws.Service;


import com.cloud.ws.Model.Marque;
import com.cloud.ws.Repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    private final MarqueRepository marqueRepository;

    @Autowired
    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public Marque saveMarque(String nom){
        Marque marque= new Marque();
        marque.setNomMarque(nom);
        marque.setEtat(0);
        marque= marqueRepository.save(marque);
        return marque;
    }

    public List<Marque> getAllMarque(){
        return marqueRepository.getAllMarque();
    }

    public Marque getById(int id){
        Marque marque= new Marque();
        marque= marqueRepository.findByIdMarque(id);
        return  marque;
    }
    public void deleteMarque(Marque marque){
        marque.setEtat(1);
        marqueRepository.save(marque);
    }

    public Marque updateMarque(Marque marque, String nom){
        marque.setNomMarque(nom);
        return marqueRepository.save(marque);
    }
}
