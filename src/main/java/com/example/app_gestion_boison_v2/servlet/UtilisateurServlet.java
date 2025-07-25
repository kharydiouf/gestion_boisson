package com.example.app_gestion_boison_v2.servlet;

import com.example.app_gestion_boison_v2.entity.Utilisateur;
import com.example.app_gestion_boison_v2.service.UtilisateurService;
import com.example.app_gestion_boison_v2.service.UtilisateurServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/utilisateurs")
public class UtilisateurServlet extends HttpServlet {
    private final UtilisateurService utilisateurService = new UtilisateurServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            resp.sendRedirect("utilisateurs?login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            String email = req.getParameter("email");
            String motDePasse = req.getParameter("motDePasse");
            Utilisateur utilisateur = utilisateurService.findByEmail(email);
            if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("utilisateur", utilisateur);
                resp.sendRedirect("boissons");
            } else {
                req.setAttribute("error", "Email ou mot de passe incorrect");
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }
        }
    }
}