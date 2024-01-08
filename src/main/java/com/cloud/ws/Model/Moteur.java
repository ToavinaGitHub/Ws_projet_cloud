package com.cloud.ws.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Moteur")
public class Moteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMoteur;

    @Column(name = "nomMoteur", nullable = false)
    private String nomMoteur;


    public Moteur(int idMoteur, String nomMoteur ) {
        this.idMoteur = idMoteur;
        this.nomMoteur = nomMoteur;
    }

    public Moteur() {
    }

    public int getIdMoteur() {
        return idMoteur;
    }

    public void setIdMoteur(int idMoteur) {
        this.idMoteur = idMoteur;
    }

    public String getNomMoteur() {
        return nomMoteur;
    }

    public void setNomMoteur(String nomMoteur) {
        this.nomMoteur = nomMoteur;
    }

}
