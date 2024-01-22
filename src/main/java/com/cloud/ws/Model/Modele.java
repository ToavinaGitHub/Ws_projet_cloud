package com.cloud.ws.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Modele")
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModele;

    @Column(name = "nomModele", nullable = false)
    private String nomModele;

    @ManyToOne
    @JoinColumn(name = "idCategorie", nullable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idMarque", nullable = false)
    private Marque marque;
    @Column(name = "etat")
    private int etat;


    public Modele(int idModele, String nomModele, Categorie categorie, Marque marque) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.categorie = categorie;
        this.marque = marque;
    }

    public Modele() {
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}

