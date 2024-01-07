package com.cloud.ws.Model;


import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;

@Entity
@Table(name = "AnnonceFavoris")
public class AnnonceFavoris {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnnonceFavoris;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idAnnonce", nullable = false)
    private Annonce annonce;

    public AnnonceFavoris(int idAnnonceFavoris, Utilisateur utilisateur, Annonce annonce) {
        this.idAnnonceFavoris = idAnnonceFavoris;
        this.utilisateur = utilisateur;
        this.annonce = annonce;
    }

    public AnnonceFavoris() {
    }

    public int getIdAnnonceFavoris() {
        return idAnnonceFavoris;
    }

    public void setIdAnnonceFavoris(int idAnnonceFavoris) {
        this.idAnnonceFavoris = idAnnonceFavoris;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
