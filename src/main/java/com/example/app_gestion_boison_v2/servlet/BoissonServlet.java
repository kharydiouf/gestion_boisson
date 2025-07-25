package com.example.app_gestion_boison_v2.servlet;

import com.example.app_gestion_boison_v2.entity.Boisson;
import com.example.app_gestion_boison_v2.service.BoissonService;
import com.example.app_gestion_boison_v2.service.BoissonServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/boissons")
public class BoissonServlet extends HttpServlet {

    private final BoissonService boissonService = new BoissonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            boissonService.delete(id);
            response.sendRedirect("boissons");
            return;
        }

        // Récupérer toutes les boissons
        List<Boisson> boissons = boissonService.findAll();
        request.setAttribute("boissons", boissons);

        // Afficher la page JSP
        request.getRequestDispatcher("/WEB-INF/boissons.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("update")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Boisson boisson = boissonService.findById(id);
            boisson.setNom(request.getParameter("nom"));
            boisson.setPrix(Double.parseDouble(request.getParameter("prix")));
            boissonService.update(boisson);
        } else {
            // Ajout d'une nouvelle boisson
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Boisson boisson = new Boisson();
            boisson.setNom(nom);
            boisson.setPrix(prix);
            boissonService.save(boisson);
        }

        // Après ajout ou update => recharger la liste
        response.sendRedirect("boissons");
    }
}
