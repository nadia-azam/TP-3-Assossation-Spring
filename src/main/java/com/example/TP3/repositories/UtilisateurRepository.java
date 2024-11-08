package com.example.TP3.repositories;

import com.example.TP3.entities.Role;
import com.example.TP3.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , Long> {
    Utilisateur findByEmail(String email);

    List<Utilisateur> findByRole(Role role);
}
