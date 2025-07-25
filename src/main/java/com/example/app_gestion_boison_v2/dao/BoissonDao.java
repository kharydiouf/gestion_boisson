package com.example.app_gestion_boison_v2.dao;

import com.example.app_gestion_boison_v2.entity.Boisson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class BoissonDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion-boissons-pu");

    public void save(Boisson boisson) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(boisson);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Boisson> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT b FROM Boisson b", Boisson.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Boisson findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Boisson.class, id);
        } finally {
            em.close();
        }
    }

    public void update(Boisson boisson) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(boisson);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Boisson boisson = em.find(Boisson.class, id);
            if (boisson != null) {
                em.remove(boisson);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}