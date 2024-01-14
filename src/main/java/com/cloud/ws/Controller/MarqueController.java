package com.cloud.ws.Controller;

import com.cloud.ws.Model.Marque;
import com.cloud.ws.Service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarqueController {
    private final MarqueService marqueService;

    @Autowired
    public MarqueController(MarqueService marqueService){
        this.marqueService=marqueService;
    }

    @PostMapping("/marque")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Marque saveMarque(@RequestParam String nom){
        return marqueService.saveMarque(nom);
    }

    @GetMapping("/marques")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Marque> getAllMarque(){
        return marqueService.getAllMarque();
    }

    @DeleteMapping("/marque/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteMarque(@PathVariable int id){
        Marque marque= marqueService.getById(id);
        marqueService.deleteMarque(marque);
    }

    @PutMapping("/marque/{id}")
    public Marque updateMarque(@PathVariable int id,String nom){
        Marque marque= marqueService.getById(id);
        return marqueService.updateMarque(marque,nom);
    }
}
