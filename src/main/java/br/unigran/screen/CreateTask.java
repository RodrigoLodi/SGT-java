package br.unigran.screen;

import br.unigran.model.Task;
import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.swing.*;

public class CreateTask extends JFrame {

    private JPanel panel;
    private JLabel lTitle;
    private JTextField title;
    private JLabel lDescription;
    private JTextArea description;
    private JLabel lDate;
    private JCalendar date;
    private JLabel lPriority;
    private JComboBox<String> priority;
    private JButton btnSalvar;
    private JButton btnSair;
    private JLabel labelUser;
    private JComboBox<String> BoxUser;

    public CreateTask() {
        config();
        components();
        action();
    }

    public void config() {
        setTitle("Create Task");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void components() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.setBackground(Color.LIGHT_GRAY);

        JPanel leftTopPanel = new JPanel(new BorderLayout());
        leftTopPanel.setBackground(Color.LIGHT_GRAY);
        JPanel leftTopInnerPanel = new JPanel(new GridLayout(2, 1));
        leftTopInnerPanel.setBackground(Color.LIGHT_GRAY);
        lTitle = new JLabel("Title:");
        lTitle.setBackground(Color.LIGHT_GRAY);
        title = new JTextField(20);
        title.setBackground(Color.WHITE);
        leftTopInnerPanel.add(lTitle);
        leftTopInnerPanel.add(title);
        lPriority = new JLabel("Priority:");
        lPriority.setBackground(Color.LIGHT_GRAY);
        String[] priorityItems = {"Normal", "Urgent"};
        priority = new JComboBox<>(priorityItems);
        priority.setBackground(Color.WHITE);
        labelUser = new JLabel("User:");
        Dados dados = new Dados();
        java.util.List<Users> users = dados.listarUsers("");
        ArrayList<String> lista = new ArrayList<>();
        for (Users user : users) {
           lista.add(user.getName());
        }
        String[] array = lista.toArray(new String[0]);
        BoxUser = new JComboBox<>(array);
        leftTopInnerPanel.add(lPriority);
        leftTopInnerPanel.add(priority);
        leftTopInnerPanel.add(labelUser);
        leftTopInnerPanel.add(BoxUser);
        leftTopPanel.add(leftTopInnerPanel, BorderLayout.NORTH);
        topPanel.add(leftTopPanel);

        JPanel rightTopPanel = new JPanel(new BorderLayout());
        rightTopPanel.setBackground(Color.LIGHT_GRAY);
        lDate = new JLabel("Date:");
        lDate.setBackground(Color.LIGHT_GRAY);
        date = new JCalendar();
        rightTopPanel.add(lDate, BorderLayout.NORTH);
        rightTopPanel.add(date, BorderLayout.CENTER);
        topPanel.add(rightTopPanel);

        panel.add(topPanel, BorderLayout.NORTH);

        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(Color.LIGHT_GRAY);
        lDescription = new JLabel("Description:");
        lDescription.setBackground(Color.LIGHT_GRAY);
        description = new JTextArea(5, 20);
        description.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(description);
        descriptionPanel.add(lDescription, BorderLayout.NORTH);
        descriptionPanel.add(scrollPane, BorderLayout.CENTER);
        panel.add(descriptionPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        btnSalvar = new JButton("Salvar");
        btnSair = new JButton("Sair");
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnSair);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void action() {
       btnSalvar.addActionListener((ActionEvent e) -> {
            Task task = new Task();
            task.setDate(date.getDate());
            task.setDescription(description.getText());
            task.setPriority(priority.getPrototypeDisplayValue());
            task.setStatus(false);
            task.setTitle(title.getText());
            Dados dados = new Dados();
            dados.salvar(task);
            List<Task> listas = dados.listarTask("");
            for (Task lista : listas) {
                System.out.println(lista.getDate() + lista.getDescription() + lista.getPriority());
            }
       });
       btnSair.addActionListener((ActionEvent e) -> {
           dispose();
       });
    }

}