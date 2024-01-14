package com.cloud.ws.Repository;

import com.cloud.ws.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    public Utilisateur findUtilisateurByIdUtilisateur(int idUtilisateur);

    public Utilisateur findByEmail(String email);
}
