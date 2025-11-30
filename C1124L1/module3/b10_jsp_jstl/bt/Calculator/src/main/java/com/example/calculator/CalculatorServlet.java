package com.example.calculator;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String operator = request.getParameter("operator");
        double number1 = Double.parseDouble(request.getParameter("number1"));
        double number2 = Double.parseDouble(request.getParameter("number2"));
        String error;
        if (operator.equals("/") && number2 == 0) {
            error = "Division by zero is not allowed.";
            request.setAttribute("error", error);
            request.getRequestDispatcher("view/calculator/calculator.jsp").forward(request, response);
            return;
        }
        Calculator calculator = new Calculator();
        try {
            double result = calculator.calculate(number1, number2, operator);
            request.setAttribute("error", null);
            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);
            request.setAttribute("operator", operator);
            request.setAttribute("result", result);
            request.getRequestDispatcher("view/calculator/calculator.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}