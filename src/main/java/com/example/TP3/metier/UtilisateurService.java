package com.example.TP3.metier;

import com.example.TP3.entities.Role;
import com.example.TP3.entities.Utilisateur;
import com.example.TP3.entities.UtilisateurImage;
import com.example.TP3.repositories.RoleRepository;
import com.example.TP3.repositories.UtilisateurImageRepository;
import com.example.TP3.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository ;

    @Autowired
    private UtilisateurImageRepository utilisateurImageRepository ;


    // Créer un utilisateur avec son rôle
    public Utilisateur createUtilisateur(String nom, String email, String roleName) {
        Role role = roleRepository.findByNomRole(roleName);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    // Ajouter une image à un utilisateur
    public UtilisateurImage addImageToUtilisateur(Long utilisateurId, String nomImage, String cheminImage) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow();
        UtilisateurImage image = new UtilisateurImage();
        image.setNomImage(nomImage);
        image.setCheminImage(cheminImage);
        image.setUtilisateur(utilisateur);
        return utilisateurImageRepository.save(image);
    }

    // Récupérer les utilisateurs par rôle
    public List<Utilisateur> getUtilisateursByRole(String roleName) {
        Role role = roleRepository.findByNomRole(roleName);
        return utilisateurRepository.findByRole(role);
    }


    public List<Utilisateur> getAllUtilisateur(){
        return  utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id){
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur assignRoleToUtilisateur(Long utilisateurId, Long roleId){
        Role role = roleRepository.findById(roleId).orElseThrow();
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow();

        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id){
        utilisateurRepository.deleteById(id);
    }


    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }




    public void deleteImage(Long utilisateurId, Long imageId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow();

        // Vérifier si l image existe pour cet utilisateur
        UtilisateurImage utilisateurImage = utilisateurImageRepository.findById(imageId)
                .orElseThrow();

        // Vérifier que l image appartient à l utilisateur
        if (!utilisateurImage.getUtilisateur().getId().equals(utilisateurId)) {
            throw new IllegalArgumentException("L'image n'appartient pas à cet utilisateur");
        }

        // Suppression
        utilisateurImageRepository.delete(utilisateurImage);
    }


}
