package com.cloud.ws.Service;

import com.cloud.ws.Model.SaryAnnonce;
import com.cloud.ws.Repository.SaryAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaryAnnonceService {

    private final SaryAnnonceRepository saryAnnonceRepository;


    @Autowired
    public SaryAnnonceService(SaryAnnonceRepository saryAnnonceRepository) {
        this.saryAnnonceRepository = saryAnnonceRepository;
    }

    public void save(SaryAnnonce s){
        saryAnnonceRepository.save(s);
    }

}
