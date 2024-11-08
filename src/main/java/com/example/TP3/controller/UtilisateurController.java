package com.example.TP3.controller;

import com.example.TP3.entities.Utilisateur;
import com.example.TP3.entities.UtilisateurImage;
import com.example.TP3.metier.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService ;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateur();
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.createUtilisateur(utilisateur.getNom(), utilisateur.getEmail(), utilisateur.getRole().getNomRole());
    }


    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }


    @PutMapping("/{utilisateurId}/role/{roleId}")
    public Utilisateur assignRoleToUtilisateur(@PathVariable Long utilisateurId, @PathVariable Long roleId) {
        return utilisateurService.assignRoleToUtilisateur(utilisateurId, roleId);
    }


    @PostMapping("/{utilisateurId}/image")
    public UtilisateurImage addImageToUtilisateur(@PathVariable Long utilisateurId, @RequestBody UtilisateurImage image) {
        return utilisateurService.addImageToUtilisateur(utilisateurId, image.getNomImage(), image.getCheminImage());
    }


    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }


    @DeleteMapping("/role/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        utilisateurService.deleteRole(roleId);
    }

    @DeleteMapping("/{utilisateurId}/image/{imageId}")
    public void deleteImage(@PathVariable Long utilisateurId, @PathVariable Long imageId) {
        utilisateurService.deleteImage(utilisateurId, imageId);
    }


}
