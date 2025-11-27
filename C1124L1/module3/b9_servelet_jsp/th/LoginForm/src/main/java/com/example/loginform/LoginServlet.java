package com.example.loginform;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        if (username.equals("admin") && password.equals("admin")) {
            writer.println("<h1>Welcome " + username + " to website</h1>");
        }else {
            writer.println("<h1>Login Error</h1>");
        }
        writer.println("</html>");
    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        PrintWriter writer = resp.getWriter();
//        writer.println("<html>");
//        if (username.equals("admin") && password.equals("admin")) {
//            writer.println("<h1>Welcome " + username + " to website</h1>");
//        }else {
//            writer.println("<h1>Login Error</h1>");
//        }
//        writer.println("</html>");
//    }
}