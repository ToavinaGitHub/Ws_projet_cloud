package com.cloud.ws.Controller;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Transmission;
import com.cloud.ws.Service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransmissionController {
    private final TransmissionService transmissionService;

    @Autowired
    public TransmissionController(TransmissionService transmissionService){
        this.transmissionService= transmissionService;
    }

    @PostMapping("/transmission")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Transmission saveTransmission(@RequestParam String nom){
        return  transmissionService.saveTransmission(nom);
    }

    @GetMapping("/transmissions")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Transmission> getAllTransmission(){
        return transmissionService.getAllTransmission();
    }

    @DeleteMapping("/transmission/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteTransmission(@PathVariable int id){
        Transmission transmission= transmissionService.getById(id);
        transmissionService.deleteTransmission(transmission);
    }

    @PutMapping("/transmission/{id}")
    public Transmission updateTransmission(@PathVariable int id, String nom){
        Transmission transmission= transmissionService.getById(id);
        return transmissionService.updateTransmission(transmission,nom);
    }
}
