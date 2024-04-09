package br.unigran.screen;

import br.unigran.model.Users;
import br.unigran.persistencia.Dados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Register extends JFrame {
    private JTextField fieldEmail;
    private JTextField fieldName;
    private JPasswordField fieldPassword;
    private JPasswordField fieldConfirmPassword;
    private JButton btnSave; // Movido para o escopo da classe
    private JButton btnCancel; // Movido para o escopo da classe

    public Register() {
        allocateComponents();
        actions();
        settings();
    }

    private void allocateComponents() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBackground(Color.LIGHT_GRAY);

        inputPanel.add(new JLabel("Email"));
        fieldEmail = new JTextField();
        inputPanel.add(fieldEmail);

        inputPanel.add(new JLabel("Nome"));
        fieldName = new JTextField();
        inputPanel.add(fieldName);

        inputPanel.add(new JLabel("Senha"));
        fieldPassword = new JPasswordField();
        inputPanel.add(fieldPassword);

        inputPanel.add(new JLabel("Confirmar Senha"));
        fieldConfirmPassword = new JPasswordField();
        inputPanel.add(fieldConfirmPassword);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Cancelar");
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void actions() {
        btnCancel.addActionListener(e -> setVisible(false));

        btnSave.addActionListener(e -> {
            String name = fieldName.getText();
            String email = fieldEmail.getText();
            char[] password = fieldPassword.getPassword();
            char[] confirmPassword = fieldConfirmPassword.getPassword();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome ou Email inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else if (!Arrays.equals(password, confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Senha inválida ou não correspondente", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                Users user = new Users();
                user.setMail(email);
                user.setName(name);
                user.setPassword(password);
                Dados dados = new Dados();
                dados.salvar(user);
                JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso!", "Aviso", JOptionPane.WARNING_MESSAGE);
                dispose();
            }
        });
    }

    private void settings() {
        setTitle("Register");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
