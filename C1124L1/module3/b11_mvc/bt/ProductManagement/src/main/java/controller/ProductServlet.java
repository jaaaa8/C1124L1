package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet (name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {
}
