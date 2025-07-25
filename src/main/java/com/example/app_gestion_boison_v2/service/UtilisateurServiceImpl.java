package com.example.app_gestion_boison_v2.service;

import com.example.app_gestion_boison_v2.dao.UtilisateurDao;
import com.example.app_gestion_boison_v2.entity.Utilisateur;
import java.util.List;

public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurDao utilisateurDao = new UtilisateurDao();

    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurDao.save(utilisateur);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }

    @Override
    public Utilisateur findById(Long id) {
        return utilisateurDao.findById(id);
    }

    @Override
    public void update(Utilisateur utilisateur) {
        utilisateurDao.update(utilisateur);
    }

    @Override
    public void delete(Long id) {
        utilisateurDao.delete(id);
    }

    @Override
    public Utilisateur findByEmail(String email) {
        // Implémentation simple : recherche via une requête JPQL
        List<Utilisateur> utilisateurs = utilisateurDao.findAll();
        return utilisateurs.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}