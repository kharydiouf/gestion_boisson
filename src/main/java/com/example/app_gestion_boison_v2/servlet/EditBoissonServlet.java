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

@WebServlet("/edit-boisson")
public class EditBoissonServlet  extends HttpServlet {

    private final BoissonService boissonService = new BoissonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        // Récupérer la boisson
        Boisson boisson = boissonService.findById(id);
        request.setAttribute("boisson", boisson);

        // Rediriger vers le formulaire de modification
        request.getRequestDispatcher("/WEB-INF/edit-boisson.jsp").forward(request, response);
    }
}
