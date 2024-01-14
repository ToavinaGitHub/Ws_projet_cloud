package com.cloud.ws.Controller;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import com.cloud.ws.Model.Marque;
import com.cloud.ws.Service.CarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarburantController {
    private final CarburantService carburantService;

    @Autowired
    public CarburantController(CarburantService carburantService){
        this.carburantService=carburantService;
    }

    @PostMapping("/carburant")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Carburant saveCarburant(@RequestParam String nom){
        return carburantService.saveCarburant(nom);
    }

    @GetMapping("/carburants")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Carburant> getAllCarburant(){
        return  carburantService.getAllCarburant();
    }

    @DeleteMapping("/carburant/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteCarburant(@PathVariable int id){
        Carburant carburant= carburantService.getById(id);
        carburantService.deleteCarburant(carburant);
    }

    @PutMapping("/carburant/{id}")
    public Carburant updateCarburant(@PathVariable int id,String nom){
        Carburant carburant= carburantService.getById(id);
        return carburantService.updateCarburant(carburant,nom);
    }
}
