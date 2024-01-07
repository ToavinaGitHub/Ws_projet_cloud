package com.cloud.ws.Repository;

import com.cloud.ws.Model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
}
