package com.cloud.ws.Service;

import com.cloud.ws.Model.Commission;
import com.cloud.ws.Repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CommissionService {
    private final CommissionRepository commissionRepository;

    @Autowired
    public CommissionService(CommissionRepository commissionRepository){
        this.commissionRepository= commissionRepository;
    }

    public Commission saveCommission(double valeur, Date date){
        Commission commission= new Commission();
        commission.setValeur(valeur);
        commission.setDateCommission(date);
        
        return commissionRepository.save(commission);
    }

    public List<Commission> all(){
        return commissionRepository.findAll();
    }

    public Commission getCommissionActuel(){
        return commissionRepository.getCommissionActuel();
    }
}
