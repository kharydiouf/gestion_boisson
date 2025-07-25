package com.example.app_gestion_boison_v2.service;

import com.example.app_gestion_boison_v2.dao.BoissonDao;
import com.example.app_gestion_boison_v2.entity.Boisson;
import java.util.List;

public class BoissonServiceImpl implements BoissonService {
    private final BoissonDao boissonDao = new BoissonDao();

    @Override
    public void save(Boisson boisson) {
        boissonDao.save(boisson);
    }

    @Override
    public List<Boisson> findAll() {
        return boissonDao.findAll();
    }

    @Override
    public Boisson findById(Long id) {
        return boissonDao.findById(id);
    }

    @Override
    public void update(Boisson boisson) {
        boissonDao.update(boisson);
    }

    @Override
    public void delete(Long id) {
        boissonDao.delete(id);
    }
}