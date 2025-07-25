package com.example.app_gestion_boison_v2;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 🚀 Redirection vers la page de login
        resp.sendRedirect("utilisateurs?login");
    }
}
