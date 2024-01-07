package com.cloud.ws.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur")
    private int idUtilisateur;

    @Column(name = "nomUtilisateur")
    private String nomUtilisateur;

    @Column(name = "prenomUtilisateur")
    private String prenomUtilisateur;

    @Column(name = "dateNaissance")
    private String dateNaissance;

    @Column(name = "sexe")
    private int sexe;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "tel")
    private String tel;

    @Column(name = "isAdmin")
    private int isAdmin;

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String dateNaissance, int sexe, String email, String password, String adresse, String tel, int isAdmin) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.tel = tel;
        this.isAdmin = isAdmin;
    }

    public Utilisateur() {
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
