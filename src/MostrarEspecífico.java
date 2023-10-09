import utils.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class MostrarEspecífico extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton voltarButton;
    private JTable table1;
    private final DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();;

    public MostrarEspecífico (DatabaseConnector conn) {
        setContentPane(panel1);
        setTitle("Mostrar especifico");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        tableModel.addColumn("id");
        tableModel.addColumn("nome");
        tableModel.addColumn("telefone");
        tableModel.addColumn("email");
        tableModel.addColumn("sexo");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contatos contatos = new Contatos();
                contatos.show();

                dispose();
            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField1.getText();
                String sql = "SELECT * FROM contatos WHERE id = '"+id+"';";
                try {
                    Statement statement = conn.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

                    tableModel.setRowCount(0);

                    while (resultSet.next()) {
                        Object[] rowData = new Object[5];
                        for (int i = 1; i <= 5; i++) {
                            rowData[i - 1] = resultSet.getObject(i);
                        }
                        tableModel.addRow(rowData);
                    }
                    resultSet.close();
                    statement.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
    }
}
