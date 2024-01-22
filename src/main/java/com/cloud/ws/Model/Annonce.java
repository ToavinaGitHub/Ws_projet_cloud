package com.cloud.ws.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnnonce;

    @Column(name = "kilometrage")
    private String kilometrage;

    @Column(name = "nbPorte")
    private Integer nbPorte;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "prixDemande")
    private Double prixDemande;

    @Column(name = "prixVente")
    private Double prixVente;

    @Column(name = "etat")
    private int etat;

    @Column(name = "dateAnnonce")
    private Timestamp dateAnnonce;

    @ManyToOne
    @JoinColumn(name = "idCommission")
    private Commission commission;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idTransmission")
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "idCarburant")
    private Carburant carburant;

    @ManyToOne
    @JoinColumn(name = "idModele", nullable = false)
    private Modele modele;


    @ManyToOne
    @JoinColumn(name = "idAnneeModele", nullable = false, columnDefinition = "integer default 0")
    private AnneeModele anneeModele;

    @ManyToOne
    @JoinColumn(name = "idMoteurModele", nullable = false, columnDefinition = "integer default 0")
    private MoteurModele moteurModele;

    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    Set<SaryAnnonce> saryAnnonces;

    public Annonce(int idAnnonce, String kilometrage, Integer nbPorte, String description, Double prixDemande, Double prixVente, int etat, Timestamp dateAnnonce, Commission commission, Utilisateur client, Transmission transmission, Carburant carburant, Modele modele) {
        this.idAnnonce = idAnnonce;
        this.kilometrage = kilometrage;
        this.nbPorte = nbPorte;
        this.description = description;
        this.prixDemande = prixDemande;
        this.prixVente = prixVente;
        this.etat = etat;
        this.dateAnnonce = dateAnnonce;
        this.commission = commission;
        this.utilisateur = client;
        this.transmission = transmission;
        this.carburant = carburant;
        this.modele = modele;
    }

    public Annonce() {
    }

    public AnneeModele getAnneeModele() {
        return anneeModele;
    }

    public void setAnneeModele(AnneeModele anneeModele) {
        this.anneeModele = anneeModele;
    }

    public MoteurModele getMoteurModele() {
        return moteurModele;
    }

    public void setMoteurModele(MoteurModele moteurModele) {
        this.moteurModele = moteurModele;
    }

    public Set<SaryAnnonce> getSaryAnnonces() {
        return saryAnnonces;
    }

    public void setSaryAnnonces(Set<SaryAnnonce> saryAnnonces) {
        this.saryAnnonces = saryAnnonces;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }


    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Integer getNbPorte() {
        return nbPorte;
    }

    public void setNbPorte(Integer nbPorte) {
        this.nbPorte = nbPorte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrixDemande() {
        return prixDemande;
    }

    public void setPrixDemande(Double prixDemande) {
        this.prixDemande = prixDemande;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Timestamp getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Timestamp dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur client) {
        this.utilisateur = client;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
}

