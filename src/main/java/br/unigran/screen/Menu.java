package br.unigran.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
        componetns();
        
    }
    
    public void config(){
        setTitle("Menu");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    private void componetns(){
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
    
        public static void main(String[] args) {
        new Menu().setVisible(true);
    }
}
