package br.unigran.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Menu extends JFrame {
    private JPanel panel;
    private JTextArea data;
    private JScrollPane scroll;
    private JButton btnRegisterTasks;
    private JButton btnUserRegistration;
    private JButton btnViewTasks;
    

    
    public Menu(){
        config();
        components();
        acoes();
    }
    
    public void config(){
        setTitle("Menu");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    private void components(){
        setLayout(new BorderLayout());
        data = new JTextArea();
        scroll = new JScrollPane(data);
        add(scroll,BorderLayout.CENTER);
        panel= new JPanel(new FlowLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        btnRegisterTasks=new JButton("Register Task");
        btnUserRegistration=new JButton("User Registration");
        btnViewTasks=new JButton("View Tasks");
        //adicionar
        panel.add(btnRegisterTasks);
        panel.add(btnUserRegistration);
        panel.add(btnViewTasks);
        add(panel, BorderLayout.PAGE_END);
    }
    
    private void acoes() {
        btnUserRegistration.addActionListener((ActionEvent e) -> {
            Register register = new Register();
            register.setVisible(true);
        });
        btnRegisterTasks.addActionListener((ActionEvent e) -> {
           CreateTask createtask = new CreateTask();
           createtask.setVisible(true);
        });
    }
}
