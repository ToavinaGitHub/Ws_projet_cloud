package com.cloud.ws.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Carburant")
public class Carburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarburant;

    @Column(name = "nomCarburant")
    private String nomCarburant;

    @Column(name = "etat")
    private int etat;

    public Carburant(int idCarburant, String nomCarburant) {
        this.idCarburant = idCarburant;
        this.nomCarburant = nomCarburant;
    }

    public Carburant() {
    }

    public int getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(int idCarburant) {
        this.idCarburant = idCarburant;
    }

    public String getNomCarburant() {
        return nomCarburant;
    }

    public void setNomCarburant(String nomCarburant) {
        this.nomCarburant = nomCarburant;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}

