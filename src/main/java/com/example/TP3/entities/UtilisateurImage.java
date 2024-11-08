package com.example.TP3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nomImage ;

    private String cheminImage ;


    @OneToOne
    private Utilisateur utilisateur ;



}
