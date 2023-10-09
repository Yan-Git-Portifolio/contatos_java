import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Excluir extends JFrame {
    private JTextField textField1;
    private JButton pesquisarButton;
    private JButton excluirButton;
    private JPanel panel1;
    private JButton voltarButton;

    public Excluir () {
        setContentPane(panel1);
        setTitle("Excluir");
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
    }

}
