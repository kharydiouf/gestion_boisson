package com.example.app_gestion_boison_v2.service;

import com.example.app_gestion_boison_v2.dao.CategorieDao;
import com.example.app_gestion_boison_v2.entity.Categorie;
import java.util.List;

public class CategorieServiceImpl implements CategorieService {
    private final CategorieDao categorieDao = new CategorieDao();

    @Override
    public void save(Categorie categorie) {
        categorieDao.save(categorie);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }

    @Override
    public Categorie findById(Long id) {
        return categorieDao.findById(id);
    }

    @Override
    public void update(Categorie categorie) {
        categorieDao.update(categorie);
    }

    @Override
    public void delete(Long id) {
        categorieDao.delete(id);
    }
}