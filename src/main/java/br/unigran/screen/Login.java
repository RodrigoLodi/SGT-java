package br.unigran.screen;

import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private JPanel panel;

    private JButton logar;
    private JButton cadastrar;
    private JTextField login;
    private JLabel loginLabel;
    private JPasswordField senha;
    private JLabel senhaLabel;
    private Users usuarioLogado;


    
    public Login() {
        alocaComponentes();
        acoes();
        configuracoes();
    }

    private void alocaComponentes() {
        panel = new JPanel(new BorderLayout());
        JPanel painelCentro = new JPanel(new GridLayout(2, 2));
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.LIGHT_GRAY);
        
        loginLabel = new JLabel("Email:");
        login = new JTextField(20);
        senhaLabel = new JLabel("Senha:");
        senha = new JPasswordField(20);
        
        logar = new JButton("Logar");
        cadastrar = new JButton("Cadastrar");

        painelCentro.add(loginLabel);
        painelCentro.add(login);
        painelCentro.add(senhaLabel);
        painelCentro.add(senha);
        
        painelBotoes.add(logar);
        painelBotoes.add(cadastrar);

        panel.add(painelCentro, BorderLayout.CENTER);
        panel.add(painelBotoes, BorderLayout.SOUTH);
        painelCentro.setBackground(Color.LIGHT_GRAY);
        painelBotoes.setBackground(Color.LIGHT_GRAY);

        add(panel);
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
                            Menu menu = new Menu(user);
                            this.setUsuarioLogado(user);
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

    public Users getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Users usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    private void configuracoes() {
        setTitle("Login");
        setSize(300, 130);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}