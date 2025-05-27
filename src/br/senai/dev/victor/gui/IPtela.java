package br.senai.dev.victor.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import br.senai.dev.victor.model.EnderecoIP;

public class IPtela {
    public void criarTela() {
        JFrame tela = new JFrame();
        tela.setSize(530, 350);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setTitle("Detalhes do IP");
        tela.setLocationRelativeTo(null);
        tela.setLayout(null);

        // Label título
        JLabel lblIP = new JLabel("Endereço IP", SwingConstants.CENTER);
        lblIP.setBounds(180, 10, 200, 50);
        lblIP.setFont(new Font("Arial", Font.BOLD, 22));
        tela.getContentPane().add(lblIP);

        // Campos texto dos octetos
        JTextField txtOctate1 = new JTextField();
        txtOctate1.setBounds(20, 70, 80, 40);
        txtOctate1.setHorizontalAlignment(JTextField.CENTER);
        txtOctate1.setFont(new Font("Monospaced", Font.PLAIN, 18));
        tela.getContentPane().add(txtOctate1);

        JLabel lblPonto1 = new JLabel(".");
        lblPonto1.setBounds(105, 70, 20, 40);
        lblPonto1.setFont(new Font("Arial", Font.BOLD, 24));
        lblPonto1.setHorizontalAlignment(SwingConstants.CENTER);
        tela.getContentPane().add(lblPonto1);

        JTextField txtOctate2 = new JTextField();
        txtOctate2.setBounds(130, 70, 80, 40);
        txtOctate2.setHorizontalAlignment(JTextField.CENTER);
        txtOctate2.setFont(new Font("Monospaced", Font.PLAIN, 18));
        tela.getContentPane().add(txtOctate2);

        JLabel lblPonto2 = new JLabel(".");
        lblPonto2.setBounds(215, 70, 20, 40);
        lblPonto2.setFont(new Font("Arial", Font.BOLD, 24));
        lblPonto2.setHorizontalAlignment(SwingConstants.CENTER);
        tela.getContentPane().add(lblPonto2);

        JTextField txtOctate3 = new JTextField();
        txtOctate3.setBounds(235, 70, 80, 40);
        txtOctate3.setHorizontalAlignment(JTextField.CENTER);
        txtOctate3.setFont(new Font("Monospaced", Font.PLAIN, 18));
        tela.getContentPane().add(txtOctate3);

        JLabel lblPonto3 = new JLabel(".");
        lblPonto3.setBounds(320, 70, 20, 40);
        lblPonto3.setFont(new Font("Arial", Font.BOLD, 24));
        lblPonto3.setHorizontalAlignment(SwingConstants.CENTER);
        tela.getContentPane().add(lblPonto3);

        JTextField txtOctate4 = new JTextField();
        txtOctate4.setBounds(340, 70, 80, 40);
        txtOctate4.setHorizontalAlignment(JTextField.CENTER);
        txtOctate4.setFont(new Font("Monospaced", Font.PLAIN, 18));
        tela.getContentPane().add(txtOctate4);

        JLabel lblBarra = new JLabel("/");
        lblBarra.setBounds(425, 70, 20, 40);
        lblBarra.setFont(new Font("Arial", Font.BOLD, 24));
        lblBarra.setHorizontalAlignment(SwingConstants.CENTER);
        tela.getContentPane().add(lblBarra);

        JTextField txtCidr = new JTextField();
        txtCidr.setBounds(445, 70, 60, 40);
        txtCidr.setHorizontalAlignment(JTextField.CENTER);
        txtCidr.setFont(new Font("Monospaced", Font.PLAIN, 18));
        tela.getContentPane().add(txtCidr);

        JButton btnMostrarDetalhes = new JButton("Mostrar Detalhes do IP");
        btnMostrarDetalhes.setBounds(160, 150, 200, 40);
        btnMostrarDetalhes.setFont(new Font("Arial", Font.PLAIN, 14));
        tela.getContentPane().add(btnMostrarDetalhes);

        // Evento do botão para mostrar detalhes do IP
        btnMostrarDetalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ipCompleto = txtOctate1.getText() + "." +
                            txtOctate2.getText() + "." +
                            txtOctate3.getText() + "." +
                            txtOctate4.getText() + "/" +
                            txtCidr.getText();

                    EnderecoIP endereco = new EnderecoIP(ipCompleto);

                    String detalhes = "Classe: " + endereco.getClasse() + "\n"
                            + "Máscara Decimal: " + endereco.getMascaraDecimal() + "\n"
                            + "Máscara Binária: " + endereco.getMascaraBinaria() + "\n"
                            + "Total de IPs: " + endereco.getTotalIPs() + "\n"
                            + "Número de Redes: " + endereco.getNumeroRedes();

                    JOptionPane.showMessageDialog(tela, detalhes, "Detalhes do IP", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tela, "Erro: entrada inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tela.setVisible(true);
    }
}