package com.example.TP3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomRole;

    @OneToMany(mappedBy = "role" , cascade = CascadeType.ALL)
    private List<Utilisateur> utilisateurs ;

}
