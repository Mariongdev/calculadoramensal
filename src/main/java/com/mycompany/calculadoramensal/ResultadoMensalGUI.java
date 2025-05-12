package com.mycompany.calculadoramensal;
import javax.swing.*;

public class ResultadoMensalGUI extends javax.swing.JFrame {

    public ResultadoMensalGUI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        salarioField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        caixaField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pagarField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        guardarField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gastarField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        medicoField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoArea = new javax.swing.JTextArea();
        calcularButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão Financeira Mensal");
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridLayout(7, 2, 5, 5));

        jLabel1.setText("Salário (R$):");
        jPanel1.add(jLabel1);
        jPanel1.add(salarioField);

        jLabel2.setText("Valor disponível no caixa (R$):");
        jPanel1.add(jLabel2);
        jPanel1.add(caixaField);

        jLabel3.setText("Total a pagar (R$):");
        jPanel1.add(jLabel3);
        jPanel1.add(pagarField);

        jLabel4.setText("Porcentagem para guardar (%):");
        jPanel1.add(jLabel4);
        jPanel1.add(guardarField);

        jLabel5.setText("Porcentagem para gastar (%):");
        jPanel1.add(jLabel5);
        jPanel1.add(gastarField);

        jLabel6.setText("Porcentagem para médico (%):");
        jPanel1.add(jLabel6);
        jPanel1.add(medicoField);

        resultadoArea.setEditable(false);
        resultadoArea.setColumns(20);
        resultadoArea.setRows(5);
        jScrollPane1.setViewportView(resultadoArea);

        calcularButton.setText("Calcular");
        calcularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(calcularButton, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calcularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void calcularButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            double salario = Double.parseDouble(salarioField.getText());
            double caixa = Double.parseDouble(caixaField.getText());
            double pagar = Double.parseDouble(pagarField.getText());
            double guardar = Double.parseDouble(guardarField.getText());
            double gastar = Double.parseDouble(gastarField.getText());
            double medico = Double.parseDouble(medicoField.getText());

            String resultado = ResultadoMensalCalculos.calcularResultados(
                salario, caixa, pagar, guardar, gastar, medico
            );

            resultadoArea.setText(resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, insira valores numéricos válidos em todos os campos.", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }                                             

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultadoMensalGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton calcularButton;
    private javax.swing.JTextField caixaField;
    private javax.swing.JTextField gastarField;
    private javax.swing.JTextField guardarField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField medicoField;
    private javax.swing.JTextField pagarField;
    private javax.swing.JTextArea resultadoArea;
    private javax.swing.JTextField salarioField;
}

