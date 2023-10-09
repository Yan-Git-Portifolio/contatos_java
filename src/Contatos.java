import utils.DatabaseConnector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Contatos extends JFrame {

    private final String jdbcUrl = "jdbc:mysql://localhost:3306/contatos";
    private final String usuario = "root";
    private final String senha = "root";

    private JButton mostrarTodosButton;
    private JButton mostrarEspecíficoButton;
    private JButton cadastrarButton;
    private JButton alterarButton;
    private JButton excluirButton;
    private JPanel MainPane;

    public Contatos () {
        setContentPane(MainPane);
        setTitle("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        DatabaseConnector databaseConnection = new DatabaseConnector(jdbcUrl, usuario, senha);
        mostrarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MostrarTodos mostrarTodos = new MostrarTodos(databaseConnection);
                    mostrarTodos.show();

                    dispose();
            }
        });
        mostrarEspecíficoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MostrarEspecífico mostrarEspecífico = new MostrarEspecífico(databaseConnection);
                    mostrarEspecífico.show();

                    dispose();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Cadastro cadastro = new Cadastro(databaseConnection);
                    cadastro.show();

                    dispose();
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Excluir excluir = new Excluir();
                excluir.show();

                dispose();
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar alterar = new Alterar();
                alterar.show();

                dispose();
            }
        });
    }

    public static void main (String[] args) {
        new Contatos();
    }
}
