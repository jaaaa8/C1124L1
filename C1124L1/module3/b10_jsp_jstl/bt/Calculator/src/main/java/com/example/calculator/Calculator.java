package com.example.calculator;

public class Calculator {
    public double calculate(double a, double b, String operator) throws Exception {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("Invalid operator");
        };
    }
}
