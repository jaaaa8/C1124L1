package com.example.customerlist.controller;

import com.example.customerlist.entity.Customer;
import com.example.customerlist.service.CustomerService;
import com.example.customerlist.service.ICustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet (name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // showAddForm(req, resp);
                break;

            default:
                List<Customer> customerList = customerService.customerList();
                req.setAttribute("customerList", customerList);
                req.getRequestDispatcher("view/customer/customer.jsp").forward(req, resp);
                break;
        }
    }
}
