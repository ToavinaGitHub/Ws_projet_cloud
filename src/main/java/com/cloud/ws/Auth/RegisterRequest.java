package com.cloud.ws.Auth;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nomUtilisateur;

    private String prenomUtilisateur;

    private String dateNaissance;

    private int sexe;

    private String email;

    private String password;

    private String adresse;
    private String tel;
    private int isAdmin;


}
