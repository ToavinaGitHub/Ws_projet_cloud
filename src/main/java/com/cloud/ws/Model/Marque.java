package com.cloud.ws.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "Marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarque;

    @Column(name = "nomMarque")
    private String nomMarque;

    public Marque() {
    }

    public Marque(int idMarque, String nomMarque) {
        this.idMarque = idMarque;
        this.nomMarque = nomMarque;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

}
