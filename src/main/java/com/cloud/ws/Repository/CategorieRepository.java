package com.cloud.ws.Repository;

import com.cloud.ws.Model.Carburant;
import com.cloud.ws.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @Query("SELECT categorie from Categorie categorie where categorie.etat=0")
    public List<Categorie> getAllCategorie();

    public Categorie findByIdCategorie(int id);
}
