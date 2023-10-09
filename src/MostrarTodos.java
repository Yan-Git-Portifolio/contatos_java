import utils.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MostrarTodos extends JFrame {
    private JPanel panel1;
    private JButton voltarButton;
    private JTable table1;

    public MostrarTodos (DatabaseConnector conn) {
        setContentPane(panel1);
        setTitle("Mostrar todos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        String sql = "SELECT * FROM contatos";
        try {
            Statement statement = conn.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }
            resultSet.close();
            statement.close();
            conn.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contatos contatos = new Contatos();
                contatos.show();

                dispose();
            }
        });
    }
}
