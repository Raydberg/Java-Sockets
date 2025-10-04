package com.server.operador;

public class OperadorServer {
    public static final int PUERTO = 1234;

    public static double processOperation(double num1, double num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> (num2 != 0) ? num1 / num2 : Double.NaN;
            default -> 0;
        };
    }
}
