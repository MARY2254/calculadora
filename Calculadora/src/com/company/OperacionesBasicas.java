package com.company;

import javax.swing.*;

public class OperacionesBasicas {
    double number1;
    double number2;
    double resultado;
    public OperacionesBasicas(){
        number1 = 0;
        number2 = 0;
        resultado = 0;
    }
    public void suma(){
        number1 = Double.parseDouble(JOptionPane.showInputDialog("Digite el primer valor"));
        number2 = Double.parseDouble(JOptionPane.showInputDialog("Digite el segundo valor"));
        resultado = number1 + number2;
        JOptionPane.showMessageDialog(null, "El resultado es " + resultado);
    }

    public void resta(){
        number1 = Double.parseDouble(JOptionPane.showInputDialog("Digite el primer valor"));
        number2 = Double.parseDouble(JOptionPane.showInputDialog("Digite el segundo valor"));
        resultado = number1 - number2;
        JOptionPane.showMessageDialog(null, "El resultado es " + resultado);
    }
    public void division(){
        number1 = Double.parseDouble(JOptionPane.showInputDialog("Digite el primer valor"));
        number2 = Double.parseDouble(JOptionPane.showInputDialog("Digite el segundo valor"));
        resultado = number1 / number2;
        JOptionPane.showMessageDialog(null, "El resultado es " + resultado);
    }
    public void multiplicacion(){
        number1 = Double.parseDouble(JOptionPane.showInputDialog("Digite el primer valor"));
        number2 = Double.parseDouble(JOptionPane.showInputDialog("Digite el segundo valor"));
        resultado = number1 * number2;
        JOptionPane.showMessageDialog(null, "El resultado es " + resultado);
    }
}
