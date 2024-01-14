package com.cloud.ws.Service;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Model.Transmission;
import com.cloud.ws.Repository.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransmissionService {
    private  final TransmissionRepository transmissionRepository;

    @Autowired
    public TransmissionService(TransmissionRepository transmissionRepository){
        this.transmissionRepository= transmissionRepository;
    }

    public Transmission saveTransmission(String nom){
        Transmission transmission= new Transmission();
        transmission.setNomTransmission(nom);
        transmission.setEtat(0);
        transmission= transmissionRepository.save(transmission);
        return transmission;
    }

    public List<Transmission> getAllTransmission(){
        return transmissionRepository.getAllTransmission();
    }

    public Transmission getById(int id){
        Transmission transmission= new Transmission();
        transmission= transmissionRepository.findByIdTransmission(id);
        return  transmission;
    }
    public void deleteTransmission(Transmission transmission){
        transmission.setEtat(1);
        transmissionRepository.save(transmission);
    }

    public Transmission updateTransmission(Transmission transmission, String nom){
        transmission.setNomTransmission(nom);
        return transmissionRepository.save(transmission);
    }
}
