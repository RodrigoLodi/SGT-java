package br.unigran.screen;

import br.unigran.model.Task;
import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;


public class Menu extends JFrame {
    private JPanel panel;
    private JTextArea data;
    private JScrollPane scroll;
    private JButton btnRegisterTasks;
    private JButton btnUserRegistration;
    private JButton btnViewTasks;
    private final Users usuarioLogado;
    

    
    public Menu(Users usuarioLogado){
        this.usuarioLogado = usuarioLogado;
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
        Dados dados = new Dados();
        List<Task> task = dados.listarTask("usertask_id=" + usuarioLogado.getId() + " and status<>true");
        data.setText("Voce tem " + task.size() + " tasks em aberto!\n Tasks:");
        for (Task tasks : task) {
            data.setText(data.getText() + "\n" + tasks.getTitle());
        }
        panel.add(btnRegisterTasks);
        panel.add(btnUserRegistration);
        panel.add(btnViewTasks);
        add(panel, BorderLayout.PAGE_END);
    }
    
    private void acoes() {
        btnUserRegistration.addActionListener((ActionEvent e) -> {
            Register register = new Register();
            data.setText("");
            register.setVisible(true);
        });
        btnRegisterTasks.addActionListener((ActionEvent e) -> {
           CreateTask createtask = new CreateTask();
           data.setText("");
           createtask.setVisible(true);
        });
        btnViewTasks.addActionListener((ActionEvent e) -> {
           ViewTask viewtask = new ViewTask(usuarioLogado);
           data.setText("");
           viewtask.setVisible(true);
        });
    }
}
