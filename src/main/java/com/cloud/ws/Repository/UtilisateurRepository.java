package com.cloud.ws.Repository;

import com.cloud.ws.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    public Utilisateur findUtilisateurByIdUtilisateur(int idUtilisateur);


    public Optional<Utilisateur> findByEmail(String email);


}
