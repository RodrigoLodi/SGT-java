package br.unigran.screen;

import br.unigran.model.Task;
import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewTask extends JFrame {
    private JPanel painel;
    private JTable jTable;
    
    public ViewTask() {
        alocaComponentes();
        acoes();
        config();
    }

    private void alocaComponentes() {
        setLayout(new BorderLayout());
        painel = new JPanel(new FlowLayout());
        jTable = new JTable();
        Dados dados = new Dados();
        List<Task> tasks = dados.listarTask("");
        String[] colunas = new String[]{"ID","Titulo", "Descricao", "Data", "Prioridade", "Status"};
        Object data[][] = new Object[tasks.size()][colunas.length];
        for (int i = 0; i < tasks.size(); i++) {
            data[i][0] = tasks.get(i).getId();
            data[i][1] = tasks.get(i).getTitle();
            data[i][2] = tasks.get(i).getDescription();
            data[i][3] = tasks.get(i).getDate();
            data[i][4] = tasks.get(i).getPriority();
            data[i][5] = tasks.get(i).isStatus();
        }
        jTable.setModel(new DefaultTableModel(data, colunas));
        painel.add(jTable);
        add(painel, BorderLayout.PAGE_START);
    }

    private void acoes() {
        
    }

    private void config() {
        setTitle("View Task");
        setSize(800, 600);
    }
    
    
}
