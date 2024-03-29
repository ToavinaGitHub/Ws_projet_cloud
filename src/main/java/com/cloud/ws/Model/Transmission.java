package com.cloud.ws.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Transmission")
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransmission;

    @Column(name = "nomTransmission")
    private String nomTransmission;

    @Column(name = "etat")
    private int etat;
    public Transmission(int idTransmission, String nomTransmission) {
        this.idTransmission = idTransmission;
        this.nomTransmission = nomTransmission;
    }

    public Transmission() {
    }

    public int getIdTransmission() {
        return idTransmission;
    }

    public void setIdTransmission(int idTransmission) {
        this.idTransmission = idTransmission;
    }

    public String getNomTransmission() {
        return nomTransmission;
    }

    public void setNomTransmission(String nomTransmission) {
        this.nomTransmission = nomTransmission;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}

