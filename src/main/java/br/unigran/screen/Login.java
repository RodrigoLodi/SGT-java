package br.unigran.screen;

import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Login extends JFrame {
    private JPanel painel1;

    private JButton logar;
    private JButton cadastrar;
    private JTextField login;
    private JLabel loginLabel;
    private JPasswordField senha;
    private JLabel senhaLabel;
    private JTable tabela = new JTable(10, 2);
    private JScrollPane scroll;
    private List teste;
    
    public Login() {
        alocaComponentes();
        acoes();
        configuracoes();
    }

    private void alocaComponentes() {
        JPanel painel = new JPanel(new GridLayout(4, 4));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painel.setBackground(Color.LIGHT_GRAY);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoesPanel.add(logar);
        botoesPanel.add(cadastrar);
        botoesPanel.setBackground(Color.LIGHT_GRAY);

        painel.add(loginLabel);
        painel.add(login);
        painel.add(senhaLabel);
        painel.add(senha);

        add(painel, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);

        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

    }
    private void acoes() {
        logar.addActionListener((ActionEvent e) -> {
            if (!login.getText().isEmpty() || senha.getPassword().length == 0) {
                Dados dados = new Dados();
                List<Users> users = dados.listarUsers("mail='" + login.getText() + "'");
                if (users.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    for (Users user : users) {
                        if (Arrays.equals(user.getPassword(), senha.getPassword())) {
                            Menu menu = new Menu();
                            menu.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha o login e a senha!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        cadastrar.addActionListener((ActionEvent e) -> {
           Register register = new Register();
           register.setVisible(true);
       });
    }
    private void configuracoes() {
        setTitle("Login");
        setSize(600, 400);
    }
}