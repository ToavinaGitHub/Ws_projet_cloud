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

    @ManyToOne
    @JoinColumn(name = "idModele", nullable = false)
    private Modele modele;

    public Moteur(int idMoteur, String nomMoteur, Modele modele) {
        this.idMoteur = idMoteur;
        this.nomMoteur = nomMoteur;
        this.modele = modele;
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

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
}
