package com.cloud.ws.Service;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Repository.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarburantService {
    private final CarburantRepository carburantRepository;

    @Autowired
    public CarburantService(CarburantRepository carburantRepository){
        this.carburantRepository= carburantRepository;
    }

    public Carburant saveCarburant(String nom){
        Carburant carburant= new Carburant();
        carburant.setNomCarburant(nom);
        carburant= carburantRepository.save(carburant);
        return carburant;
    }

    public List<Carburant> getAllCarburant(){
        return carburantRepository.getAllCaburant();
    }

    public Carburant getById(int id){
        Carburant carburant= new Carburant();
        carburant= carburantRepository.findByIdCarburant(id);
        return  carburant;
    }
    public void deleteCarburant(Carburant  carburant){
        carburant.setEtat(1);
        carburantRepository.save(carburant);
    }

    public Carburant updateCarburant(Carburant carburant, String nom){
        carburant.setNomCarburant(nom);
        return  carburantRepository.save(carburant);
    }
}
