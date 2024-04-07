package br.unigran.screen;

import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
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
        setLayout(new BorderLayout());
        painel1 = new JPanel(new FlowLayout());
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        
        login = new JTextField(150);
        loginLabel = new JLabel("Email");
        
        senha = new JPasswordField(20);
        senhaLabel = new JLabel("Senha");
        
        painel1.add(loginLabel);
        painel1.add(login);
        
        painel1.add(senhaLabel);
        painel1.add(senha);
        
        logar = new JButton("Logar");
        cadastrar = new JButton("Cadastrar");
        
        painel1.add(logar);
        painel1.add(cadastrar);
        
        add(painel1,BorderLayout.PAGE_START);
        
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
