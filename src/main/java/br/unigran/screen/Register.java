package br.unigran.screen;

import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame {
    private JPanel painel1;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JTextField campoEmail;
    private JTextField campoNome;
    private JPasswordField campoSenha;
    private JPasswordField campoConfirmaSenha;
    private JLabel labelEmail;
    private JLabel labelNome;
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
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        
        campoEmail = new JTextField(50);
        campoNome = new JTextField(50);
        campoSenha = new JPasswordField(20);
        campoConfirmaSenha = new JPasswordField(20);
        
        labelEmail = new JLabel("Email");
        labelNome = new JLabel("Nome");
        labelSenha = new JLabel("Senha");
        labelConfirmaSenha = new JLabel("Confirmar Senha");
        
        painel1.add(labelEmail);
        painel1.add(campoEmail);
        painel1.add(labelNome);
        painel1.add(campoNome);
        painel1.add(labelSenha);
        painel1.add(campoSenha);
        painel1.add(labelConfirmaSenha);
        painel1.add(campoConfirmaSenha);
        painel1.add(botaoSalvar);
        painel1.add(botaoCancelar);
        
        add(painel1,BorderLayout.PAGE_START);
    }

    private void acoes() {
        botaoCancelar.addActionListener((ActionEvent e) -> {
           this.setVisible(false);
        });
        botaoSalvar.addActionListener((ActionEvent e) -> {
            if (!campoNome.getText().isEmpty()) {
                if (!campoEmail.getText().isEmpty()) {
                    char[] senha = campoSenha.getPassword();
                    char[] confirmaSenha = campoConfirmaSenha.getPassword();

                    if (senha.length == 0 || !Arrays.equals(senha, confirmaSenha)) {
                        JOptionPane.showMessageDialog(null, "Senha inválida ou não correspondente", "Aviso", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Users user = new Users();
                        user.setMail(campoEmail.getText());
                        user.setName(campoNome.getText());
                        user.setPassword(campoSenha.getPassword());
                        Dados dados = new Dados();
                        dados.salvar(user);
                        JOptionPane.showMessageDialog(null, "Usuario registrado com sucesso!", "Aviso", JOptionPane.WARNING_MESSAGE);
                        dispose();
                    }
                 } else {
                    JOptionPane.showMessageDialog(null, "Email inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
                 }
            } else {
                JOptionPane.showMessageDialog(null, "Nome inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void configuracoes() {
        setTitle("Register");
        setSize(400, 300);
    }
    
    
}
