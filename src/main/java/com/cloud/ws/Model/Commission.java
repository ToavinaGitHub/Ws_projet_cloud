package com.cloud.ws.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Commission")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommission;

    @Column(name = "valeur")
    private double valeur;

    @Column(name = "dateCommission")
    private Date dateCommission;

    public Commission(int idCommission, double valeur, Date dateCommission) {
        this.idCommission = idCommission;
        this.valeur = valeur;
        this.dateCommission = dateCommission;
    }

    public Commission() {
    }

    public int getIdCommission() {
        return idCommission;
    }

    public void setIdCommission(int idCommission) {
        this.idCommission = idCommission;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Date getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Date dateCommission) {
        this.dateCommission = dateCommission;
    }
}
