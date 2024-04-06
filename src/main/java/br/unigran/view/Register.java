package br.unigran.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame {
    private JPanel painel1;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JTextField campoEmail;
    private JTextField campoSenha;
    private JTextField campoConfirmaSenha;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JLabel labelConfirmaSenha;

    public Register() {
        alocaComponentes();
        acoes();
        configuracoes();
    }

    private void alocaComponentes() {
        setLayout(new BorderLayout());
        
        painel1 = new JPanel(new FlowLayout());
        
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        
        campoEmail = new JTextField(50);
        campoSenha = new JTextField(20);
        campoConfirmaSenha = new JTextField(20);
        
        labelEmail = new JLabel("Email");
        labelSenha = new JLabel("Senha");
        labelConfirmaSenha = new JLabel("Confirmar Senha");
        
        painel1.add(labelEmail);
        painel1.add(campoEmail);
        painel1.add(labelSenha);
        painel1.add(campoSenha);
        painel1.add(labelConfirmaSenha);
        painel1.add(campoConfirmaSenha);
        
        add(painel1,BorderLayout.PAGE_START);
    }

    private void acoes() {
        
    }

    private void configuracoes() {
        setTitle("Register");
        setSize(400, 200);
    }
    
    
}
