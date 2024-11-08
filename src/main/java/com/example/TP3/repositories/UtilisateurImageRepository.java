package com.example.TP3.repositories;

import com.example.TP3.entities.UtilisateurImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurImageRepository extends JpaRepository<UtilisateurImage,Long> {
    UtilisateurImage findByUtilisateurId(Long utilisateurId);

}
