package com.cloud.ws.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "SaryAnnonce")
public class SaryAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSaryAnnonce;

    @Column(name = "sary", columnDefinition = "TEXT")
    private String sary;

    @ManyToOne
    @JoinColumn(name = "idAnnonce", nullable = false)
    @JsonBackReference
    private Annonce annonce;

    public SaryAnnonce(int idSaryAnnonce, String sary, Annonce annonce) {
        this.idSaryAnnonce = idSaryAnnonce;
        this.sary = sary;
        this.annonce = annonce;
    }

    public SaryAnnonce() {
    }

    public int getIdSaryAnnonce() {
        return idSaryAnnonce;
    }

    public void setIdSaryAnnonce(int idSaryAnnonce) {
        this.idSaryAnnonce = idSaryAnnonce;
    }

    public String getSary() {
        return sary;
    }

    public void setSary(String sary) {
        this.sary = sary;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
