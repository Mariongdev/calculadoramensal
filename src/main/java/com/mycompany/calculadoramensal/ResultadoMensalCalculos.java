package com.mycompany.calculadoramensal;

import java.text.DecimalFormat;

public class ResultadoMensalCalculos {
    public static String calcularResultados(double salario, double caixa, double pagar, 
                                          double guardar, double gastar, double medico) {
        double resultado = salario - pagar;
        double deve_guardar = resultado * guardar / 100;
        double guardar_medico = resultado * medico / 100;
        double pode_gastar = resultado * gastar / 100;
        double saldo_caixa = caixa + deve_guardar;

        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();

        sb.append("Valor em caixa: R$ ").append(df.format(caixa)).append("\n");
        sb.append("Salario do mes: R$ ").append(df.format(salario)).append("\n");
        sb.append("Total a pagar: R$ ").append(df.format(pagar)).append("\n");
        sb.append("Vai sobrar: R$ ").append(df.format(resultado)).append("\n\n");

        sb.append(deve_guardar > 0 ? 
            "Voce deve guardar em caixa: R$ " + df.format(deve_guardar) + "\n" : 
            "Voce deve guardar: R$ Saldo negativo!\n");

        sb.append(guardar_medico > 0 ? 
            "Voce deve guardar para o medico: R$ " + df.format(guardar_medico) + "\n" : 
            "Voce deve guardar para o medico: R$ Saldo negativo!\n");

        sb.append(pode_gastar > 0 ? 
            "Voce pode gastar: R$ " + df.format(pode_gastar) + "\n" : 
            "Voce pode gastar: R$ Saldo negativo\n");

        sb.append("Total em caixa: R$ ").append(df.format(resultado > 0 ? saldo_caixa : caixa + resultado)).append("\n");

        return sb.toString();
    }
}