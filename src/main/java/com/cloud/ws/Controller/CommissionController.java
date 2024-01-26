package com.cloud.ws.Controller;

import com.cloud.ws.Model.Commission;
import com.cloud.ws.Service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class CommissionController {
    private final CommissionService commissionService;

    @Autowired
    public CommissionController(CommissionService commissionService){
        this.commissionService= commissionService;
    }

    @PostMapping("/commission")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Commission saveCommission(@RequestParam double valeur){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        /*calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);*/
        Date daty = calendar.getTime();
        return commissionService.saveCommission(valeur,daty);
    }

    @GetMapping("/commissions")
    @CrossOrigin(origins = "*" , allowedHeaders = "*")

    public List<Commission> getAll(){
        return commissionService.all();
    }

}
