package com.example.app_gestion_boison_v2;

import com.example.app_gestion_boison_v2.dao.BoissonDao;
import com.example.app_gestion_boison_v2.dao.CategorieDao;
import com.example.app_gestion_boison_v2.dao.UtilisateurDao;
import com.example.app_gestion_boison_v2.entity.Boisson;
import com.example.app_gestion_boison_v2.entity.Categorie;
import com.example.app_gestion_boison_v2.entity.Utilisateur;

public class Main {
    public static void main(String[] args) {
        // Initialisation des DAO
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        CategorieDao categorieDao = new CategorieDao();
        BoissonDao boissonDao = new BoissonDao();

        // Création d'un utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Jean Dupont");
        utilisateur.setEmail("titi@gmail.com");
        utilisateur.setMotDePasse("passer");
        utilisateurDao.save(utilisateur);
        System.out.println("Utilisateur créé : " + utilisateur.getId());

        // Création d'une catégorie
        Categorie categorie = new Categorie();
        categorie.setNom("Boissons gazeuses");
        categorieDao.save(categorie);
        System.out.println("Catégorie créée : " + categorie.getId());

        // Création d'une boisson
        Boisson boisson = new Boisson();
        boisson.setNom("Coca-Cola");
        boisson.setPrix(1.50);
        boisson.setCategorie(categorie); // Lien avec la catégorie
        boissonDao.save(boisson);
        System.out.println("Boisson créée : " + boisson.getId());

        // Récupération et affichage
        Utilisateur foundUser = utilisateurDao.findByEmail("jean.dupont@example.com");
        System.out.println("Utilisateur trouvé : " + foundUser.getNom());

        Categorie foundCategorie = categorieDao.findById(categorie.getId());
        System.out.println("Catégorie trouvée : " + foundCategorie.getNom());

        Boisson foundBoisson = boissonDao.findById(boisson.getId());
        System.out.println("Boisson trouvée : " + foundBoisson.getNom() + ", Prix : " + foundBoisson.getPrix());

        // Nettoyage (optionnel)
        boissonDao.delete(boisson.getId());
        categorieDao.delete(categorie.getId());
        utilisateurDao.delete(utilisateur.getId());
        System.out.println("Données supprimées.");
    }
}