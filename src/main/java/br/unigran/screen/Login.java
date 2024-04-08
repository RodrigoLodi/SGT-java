package br.unigran.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login extends JFrame {

    private JLabel loginLabel;
    private JTextField loginField;
    private JLabel senhaLabel;
    private JPasswordField senhaField;
    private JButton logarButton;
    private JButton cadastrarButton;

    public Login() {
        criarComponentes();
        configurarJanela();
    }

    private void criarComponentes() {
        loginLabel = new JLabel("Email:");
        loginField = new JTextField(20);
        senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);
        logarButton = new JButton("Logar");
        cadastrarButton = new JButton("Cadastrar");

        logarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void configurarJanela() {
        JPanel painel = new JPanel(new GridLayout(4, 4));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painel.setBackground(Color.LIGHT_GRAY);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoesPanel.add(logarButton);
        botoesPanel.add(cadastrarButton);
        botoesPanel.setBackground(Color.LIGHT_GRAY);

        painel.add(loginLabel);
        painel.add(loginField);
        painel.add(senhaLabel);
        painel.add(senhaField);

        add(painel, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);

        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
