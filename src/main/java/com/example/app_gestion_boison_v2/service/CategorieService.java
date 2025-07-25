package com.example.app_gestion_boison_v2.service;


import com.example.app_gestion_boison_v2.entity.Categorie;
import java.util.List;

public interface CategorieService {
    void save(Categorie categorie);
    List<Categorie> findAll();
    Categorie findById(Long id);
    void update(Categorie categorie);
    void delete(Long id);
}