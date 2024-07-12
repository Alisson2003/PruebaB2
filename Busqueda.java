import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Busqueda extends JFrame {
    private JPanel Panel1;
    private JTextArea PRODUCTOBUSCADOTextArea;
    private JButton Regresar;
    private JButton Login;


    public Busqueda() {
        super("PRODUCTOBUSCADOTextArea");
        setContentPane(Panel1);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Regresar = new JButton("Regresando ... ");
                Regresar.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Registro registroFrame = new Registro();
                        registroFrame.setVisible(true);
                        dispose();
                    }
                });
            }

        });
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.add(Regresar, BorderLayout.SOUTH);

                Login = new JButton("Salir");
                Login.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Login loginFrame = new Login();
                        loginFrame.setVisible(true);
                        dispose();                    }
                 });
            Panel1.add(Login, BorderLayout.SOUTH);
            }

        });
    }
}