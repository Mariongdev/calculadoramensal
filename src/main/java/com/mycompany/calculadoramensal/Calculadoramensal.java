/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoramensal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculadoramensal {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Gestão Financeira Mensal");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10, 10));

        // Painel de entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        
        // Componentes de entrada
        JTextField salarioField = new JTextField();
        JTextField caixaField = new JTextField();
        JTextField pagarField = new JTextField();
        JTextField guardarField = new JTextField();
        JTextField gastarField = new JTextField();
        JTextField medicoField = new JTextField();

        // Adicionar campos ao painel
        inputPanel.add(new JLabel("Salário (R$):"));
        inputPanel.add(salarioField);
        inputPanel.add(new JLabel("Valor disponível no caixa (R$):"));
        inputPanel.add(caixaField);
        inputPanel.add(new JLabel("Total a pagar (R$):"));
        inputPanel.add(pagarField);
        inputPanel.add(new JLabel("Porcentagem para guardar (%):"));
        inputPanel.add(guardarField);
        inputPanel.add(new JLabel("Porcentagem para gastar (%):"));
        inputPanel.add(gastarField);
        inputPanel.add(new JLabel("Porcentagem para médico (%):"));
        inputPanel.add(medicoField);

        // Área de resultados
        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        // Botão de calcular
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter valores dos campos
                    double salario = Double.parseDouble(salarioField.getText());
                    double caixa = Double.parseDouble(caixaField.getText());
                    double pagar = Double.parseDouble(pagarField.getText());
                    double guardar = Double.parseDouble(guardarField.getText());
                    double gastar = Double.parseDouble(gastarField.getText());
                    double medico = Double.parseDouble(medicoField.getText());

                    // Realizar cálculos
                    double resultado = salario - pagar;
                    double deve_guardar = resultado * guardar / 100;
                    double guardar_medico = resultado * medico / 100;
                    double pode_gastar = resultado * gastar / 100;
                    double saldo_caixa = caixa + deve_guardar;

                    // Formatar saída
                    DecimalFormat df = new DecimalFormat("0.00");
                    StringBuilder sb = new StringBuilder();

                    sb.append("Valor em caixa: R$ ").append(df.format(caixa)).append("\n");
                    sb.append("Salario do mes: R$ ").append(df.format(salario)).append("\n");
                    sb.append("Total a pagar: R$ ").append(df.format(pagar)).append("\n");
                    sb.append("Vai sobrar: R$ ").append(df.format(resultado)).append("\n\n");

                    if (deve_guardar > 0) {
                        sb.append("Voce deve guardar em caixa: R$ ").append(df.format(deve_guardar)).append("\n");
                    } else {
                        sb.append("Voce deve guardar: R$ Saldo negativo!\n");
                    }

                    if (guardar_medico > 0) {
                        sb.append("Voce deve guardar para o medico: R$ ").append(df.format(guardar_medico)).append("\n");
                    } else {
                        sb.append("Voce deve guardar para o medico: R$ Saldo negativo!\n");
                    }

                    if (pode_gastar > 0) {
                        sb.append("Voce pode gastar: R$ ").append(df.format(pode_gastar)).append("\n");
                    } else {
                        sb.append("Voce pode gastar: R$ Saldo negativo\n");
                    }

                    if (resultado > 0) {
                        sb.append("Total em caixa: R$ ").append(df.format(saldo_caixa)).append("\n");
                    } else {
                        sb.append("Total em caixa: R$ ").append(df.format(caixa + resultado)).append("\n");
                    }

                    resultadoArea.setText(sb.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos em todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionar componentes à janela
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(calcularButton, BorderLayout.SOUTH);

        // Centralizar a janela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}