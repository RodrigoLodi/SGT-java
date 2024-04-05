package br.unigran.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Login extends JFrame {
    private JPanel painel1;
   
    private JButton confirmar;
    private JButton cadastrar;
    private JTextField login;
    private JLabel loginLabel;
    private JTextField senha;
    private JLabel senhaLabel;
    private JTable tabela = new JTable(10, 2);
    private JScrollPane scroll;
    
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
        
        confirmar = new JButton("Logar");
        cadastrar = new JButton("Cadastrar");
        
        painel1.add(confirmar);
        painel1.add(cadastrar);
        
        add(painel1,BorderLayout.PAGE_START);
        
    }
    private void acoes() {
        confirmar.addActionListener((ActionEvent e) -> {
            Object singleResult = em.createQuery("select O from Usuario O " + "where O.login=? and O.senha =:senha").setParameter("login", u.getLogin()).setParameter("senha",u.getSenha()).getSingleResult();
       });
    }
    private void configuracoes() {
        setTitle("Login");
        setSize(600, 400);
    }
}
