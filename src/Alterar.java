import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alterar extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton alterarButton;
    private JPanel panel1;
    private JButton voltarButton;

    public Alterar () {
        setContentPane(panel1);
        setTitle("Alterar");
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
