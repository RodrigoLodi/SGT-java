package br.unigran.screen;

import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Login extends JFrame {
    private JPanel painel1;
   
    private JButton logar;
    private JButton cadastrar;
    private JTextField login;
    private JLabel loginLabel;
    private JTextField senha;
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
        
        login = new JTextField(20);
        loginLabel = new JLabel("Login");
        
        senha = new JTextField(20);
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
           Dados dados = new Dados();
           teste = dados.Login("*", "User", "");
           System.out.println(teste);
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
