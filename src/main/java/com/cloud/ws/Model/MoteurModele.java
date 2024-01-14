package com.cloud.ws.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "MoteurModele")
public class MoteurModele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMoteurModele;

    @ManyToOne
    @JoinColumn(name = "idMoteur" , nullable = false)
    Moteur moteur;

    @ManyToOne
    @JoinColumn(name = "idModele" , nullable = false)
    Modele modele;

    @Column(name = "etat")
    private int etat;

    public MoteurModele(int idMoteurModele, Moteur moteur, Modele modele) {
        this.idMoteurModele = idMoteurModele;
        this.moteur = moteur;
        this.modele = modele;
    }

    public MoteurModele() {
    }

    public int getIdMoteurModele() {
        return idMoteurModele;
    }

    public void setIdMoteurModele(int idMoteurModele) {
        this.idMoteurModele = idMoteurModele;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }
    public Modele getModele() {
        return modele;
    }
    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
