import utils.DatabaseConnector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends JFrame {
    private JPanel panel1;
    private JTextField nome;
    private JTextField telefone;
    private JTextField email;
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JComboBox sexo;

    public Cadastro (DatabaseConnector conn) {
        setContentPane(panel1);
        setTitle("Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);


        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contatos contatos = new Contatos();
                contatos.show();

                dispose();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeContent = nome.getText();
                String telefoneContent = telefone.getText();
                String emailContent = email.getText();
                String sexoContent = sexo.getSelectedItem().toString();

                String sql = "INSERT INTO contatos (nome, telefone, email, sexo) VALUES ('"+nomeContent+"', '"+telefoneContent+"', " +
                        "'"+emailContent+"', '"+sexoContent.charAt(0)+"');";
                try {
                    PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);

                    Integer rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully.");
                    } else {
                        System.out.println("Data insertion failed.");
                    }

                    preparedStatement.close();
                    conn.getConnection().close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

}
