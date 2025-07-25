package com.example.app_gestion_boison_v2.service;

import com.example.app_gestion_boison_v2.entity.Boisson;
import java.util.List;

public interface BoissonService {
    void save(Boisson boisson);
    List<Boisson> findAll();
    Boisson findById(Long id);
    void update(Boisson boisson);
    void delete(Long id);
}