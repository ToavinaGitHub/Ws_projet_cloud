package com.cloud.ws.Model;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class RechercheMultiple {

    private String keyword;
    private Timestamp date;
    private Categorie categorie;
    private double prixMin;
    private double prixMax;
    private Marque marque;
    private Modele modele;
    private Moteur moteur;
    private Carburant carburant;
    private double minKilometrage;
    private  double maxKilometrage;
    private Timestamp minDate;
    private Timestamp maxDate;


    public RechercheMultiple(){

    }

    public RechercheMultiple(String keyword, Timestamp date, Categorie categorie, double prixMin, double prixMax, Marque marque, Modele modele, Moteur moteur, Carburant carburant, double minKilometrage, double maxKilometrage, Timestamp minDate, Timestamp maxDate) {
        this.keyword = keyword;
        this.date = date;
        this.categorie = categorie;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.marque = marque;
        this.modele = modele;
        this.moteur = moteur;
        this.carburant = carburant;
        this.minKilometrage = minKilometrage;
        this.maxKilometrage = maxKilometrage;
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public void setMinKilometrage(double minKilometrage) {
        this.minKilometrage = minKilometrage;
    }

    public void setMaxKilometrage(double maxKilometrage) {
        this.maxKilometrage = maxKilometrage;
    }

    public void setMinDate(Timestamp minDate) {
        this.minDate = minDate;
    }

    public void setMaxDate(Timestamp maxDate) {
        this.maxDate = maxDate;
    }
}
