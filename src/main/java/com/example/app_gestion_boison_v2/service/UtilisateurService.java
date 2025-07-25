package com.example.app_gestion_boison_v2.service;

import com.example.app_gestion_boison_v2.entity.Utilisateur;
import java.util.List;

public interface UtilisateurService {
    void save(Utilisateur utilisateur);
    List<Utilisateur> findAll();
    Utilisateur findById(Long id);
    void update(Utilisateur utilisateur);
    void delete(Long id);
    Utilisateur findByEmail(String email);
}