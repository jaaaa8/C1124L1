package controller;

import entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.IProductService;
import service.ProductService;

import java.io.IOException;

@WebServlet (name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // handle create product
                addNewProduct(req, resp);
                break;
            case "delete":
                // handle edit product
                deleteProduct(req, resp);
                break;
            case "update":
                // handle update product
                updateProduct(req, resp);
                break;
            case "list":
                // handle list products
                showProductList(req, resp);
                break;
            default:
                // handle default action
                break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String newName = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String category = req.getParameter("category");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        float discount = Float.parseFloat(req.getParameter("discount"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            req.setAttribute("error", "Product doesn't exist");
            dispatcher = req.getRequestDispatcher("view/error.jsp");
        } else {
            product.setName(newName);
            product.setPrice(price);
            product.setCategory(category);
            product.setQuantity(quantity);
            product.setDiscount(discount);
            this.productService.updateProduct(product);
            req.setAttribute("product", product);
            req.setAttribute("message", "Product updated successfully");
            dispatcher = req.getRequestDispatcher("view/product/update.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.productService.findProductById(id);

        if (product == null) {
            resp.sendRedirect("view/error.jsp");
            return;
        }

        this.productService.deleteProduct(product);
        resp.sendRedirect("/products");
    }


    private void addNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String category = req.getParameter("category");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        float discount = Float.parseFloat(req.getParameter("discount"));
        int newID = this.productService.size() + 1;
        Product product = new Product(newID, name, price, category, quantity, discount);
        this.productService.addProduct(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/product/add.jsp");
        req.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // handle create product
                showAddForm(req, resp);
                break;
            case "delete":
                // handle edit product
                showDeleteForm(req, resp);
                break;
            case "detail":
                // handle delete product
                showProductDetail(req, resp);
                break;
            case "list":
                // handle list products
                showProductList(req, resp);
                break;
            case "update":
                // handle update product
                showUpdateForm(req, resp);
                break;
            default:
                // handle default action
                showProductList(req, resp);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            req.setAttribute("error", "Product doesn't exist");
            dispatcher = req.getRequestDispatcher("view/error.jsp");
        }else {
            req.setAttribute("product", product);
            dispatcher = req.getRequestDispatcher("view/product/update.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("products", this.productService.findAllProducts());
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/product/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void showProductDetail(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("view/error.jsp");
        } else {
            req.setAttribute("product", product);
            dispatcher = req.getRequestDispatcher("view/product/detail.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("view/error.jsp");
        } else {
            req.setAttribute("product", product);
            dispatcher = req.getRequestDispatcher("view/product/delete.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/product/add.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
