package com.cloud.ws.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "AnneeModele")
public class AnneeModele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAnneeModele;

    String annee;

    @ManyToOne
    @JoinColumn(name = "idModele" ,nullable = false)
    Modele modele;

    public AnneeModele(int idAnneeModele, String annee, Modele modele) {
        this.idAnneeModele = idAnneeModele;
        this.annee = annee;
        this.modele = modele;
    }

    public AnneeModele() {
    }

    public int getIdAnneeModele() {
        return idAnneeModele;
    }

    public void setIdAnneeModele(int idAnneeModele) {
        this.idAnneeModele = idAnneeModele;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
}
