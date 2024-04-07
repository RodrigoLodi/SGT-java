package br.unigran.screen;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CreateTask extends JFrame {
    
    private TextField title;
    private TextArea description;
    private Date date;
    private JComboBox priority;
    
    public CreateTask(){
        config();
        componetns();
    }
    
    public void config(){
        setTitle("Create Task");
        setSize(800, 300);
        
        
    }
    
    public void componetns(){
        
    }
    
}