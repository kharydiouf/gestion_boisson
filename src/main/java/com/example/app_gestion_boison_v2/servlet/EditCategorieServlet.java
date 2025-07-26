package com.example.app_gestion_boison_v2.servlet;

import com.example.app_gestion_boison_v2.entity.Categorie;
import com.example.app_gestion_boison_v2.service.CategorieService;
import com.example.app_gestion_boison_v2.service.CategorieServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-categorie")
public class EditCategorieServlet extends HttpServlet {

    private final CategorieService categorieService = new CategorieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ 1. Récupérer l'ID depuis l'URL
        Long id = Long.parseLong(request.getParameter("id"));

        // ✅ 2. Trouver la catégorie
        Categorie categorie = categorieService.findById(id);

        // ✅ 3. Envoyer la catégorie vers la JSP
        request.setAttribute("categorie", categorie);
        request.getRequestDispatcher("/WEB-INF/edit-categorie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ 1. Récupérer les données du formulaire
        Long id = Long.parseLong(request.getParameter("id"));
        String nom = request.getParameter("nom");

        // ✅ 2. Trouver et mettre à jour la catégorie
        Categorie categorie = categorieService.findById(id);
        categorie.setNom(nom);
        categorieService.update(categorie);

        // ✅ 3. Rediriger vers la liste des catégories
        response.sendRedirect("categories");
    }
}
