package br.unigran.screen;

import br.unigran.model.Task;
import br.unigran.model.Users;
import br.unigran.persistencia.Dados;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewTask extends JFrame {
    private JPanel painel;
    private JTable jTable;
    private String statusTask;
    private final Users usuarioLogado;
    
    public ViewTask(Users usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        alocaComponentes();
        acoes();
        config();
    }

    private void alocaComponentes() {
    setLayout(new BorderLayout());
    System.out.println("Usuario: " + usuarioLogado);
    painel = new JPanel(new BorderLayout());
    jTable = new JTable();
    Dados dados = new Dados();
    List<Task> tasks = dados.listarTask("usertask_id=" + usuarioLogado.getId());
    String[] colunas = new String[]{"ID","Titulo", "Descricao", "Data", "Prioridade", "Status (Clique para alterar)"};
    Object data[][] = new Object[tasks.size()][colunas.length];
    for (int i = 0; i < tasks.size(); i++) {
        if (tasks.get(i).isStatus()) {
            statusTask = "Concluido";
        } else {
            statusTask = "Não Concluido";
        }
        data[i][0] = tasks.get(i).getId();
        data[i][1] = tasks.get(i).getTitle();
        data[i][2] = tasks.get(i).getDescription();
        data[i][3] = tasks.get(i).getDate();
        data[i][4] = tasks.get(i).getPriority();
        data[i][5] = statusTask;
    }
    DefaultTableModel model = new DefaultTableModel(data, colunas);
    jTable.setModel(model);
    
    jTable.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int column = jTable.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / jTable.getRowHeight();
            if (column == 5 && row < jTable.getRowCount()) {
                String status = (String) jTable.getValueAt(row, column);
                int id = (int) jTable.getValueAt(row, 0);
                List<Task> task_update = dados.listarTask("id=" + id);
                if (status == "Concluido") {
                    task_update.get(0).setStatus(false);
                    status = "Não Concluido";
                } else {
                    task_update.get(0).setStatus(true);
                    status = "Concluido";
                }
                dados.atualiza(task_update.get(0));
                jTable.setValueAt(status, row, column);
            }
        }
    });
    
    JScrollPane scrollPane = new JScrollPane(jTable);
    painel.add(jTable.getTableHeader(), BorderLayout.PAGE_START);
    
    painel.add(scrollPane, BorderLayout.CENTER);
    
    add(painel, BorderLayout.CENTER);
}


    private void acoes() {
        
    }

    private void config() {
        setTitle("View Task");
        setSize(800, 600);
    }
    
    
}
