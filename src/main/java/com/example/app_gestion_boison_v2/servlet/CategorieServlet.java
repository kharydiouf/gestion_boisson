package com.example.app_gestion_boison_v2.servlet;

import com.example.app_gestion_boison_v2.entity.Categorie;
import com.example.app_gestion_boison_v2.service.CategorieService;
import com.example.app_gestion_boison_v2.service.CategorieServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/categories")
public class CategorieServlet extends HttpServlet {
    private final CategorieService categorieService = new CategorieServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("utilisateur") == null) {
            resp.sendRedirect("utilisateurs?login");
            return;
        }

        // Vérifier s'il y a une action (delete par exemple)
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            Long id = Long.parseLong(req.getParameter("id"));
            categorieService.delete(id);
            resp.sendRedirect("categories");
            return;
        }

        // Récupérer toutes les catégories
        List<Categorie> categories = categorieService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/categories.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("utilisateur") == null) {
            resp.sendRedirect("utilisateurs?login");
            return;
        }

        String action = req.getParameter("action");

        if (action != null && action.equals("update")) {
            // ✅ Mise à jour d'une catégorie existante
            Long id = Long.parseLong(req.getParameter("id"));
            Categorie categorie = categorieService.findById(id);

            if (categorie != null) {
                categorie.setNom(req.getParameter("nom"));
                categorieService.update(categorie);
            }

            resp.sendRedirect("categories");

        } else {
            // ✅ Ajout d'une nouvelle catégorie
            String nom = req.getParameter("nom");

            if (nom == null || nom.trim().isEmpty()) {
                req.setAttribute("error", "Le nom de la catégorie est requis");
                List<Categorie> categories = categorieService.findAll();
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/WEB-INF/categories.jsp").forward(req, resp);
                return;
            }

            Categorie categorie = new Categorie();
            categorie.setNom(nom);
            categorieService.save(categorie);

            resp.sendRedirect("categories");
        }
    }
}
