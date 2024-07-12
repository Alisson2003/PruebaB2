import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame{
    public JPanel Panel1;
    private JTextField usu;
    private JPasswordField contra;
    private JButton Iniciar;

    public Login(){
        super("BIENVENIDO AL LOGIN");
        setContentPane(Panel1);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String url = "jdbc:mysql://localhost:3306/productos_cp";
        String usu = "username";
        String password = "password";

        Iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes";
                String usu = "username"+ url;
                String password = "pasword"+ url;

                if (usu.equals(usu) && password.equals(password)){
                    Registro registroFrame = new Registro();
                    registroFrame.setVisible(true);
                    dispose();

                }else {
                    JOptionPane.showMessageDialog(null, "CREDENCIALES INCORRECTAS", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
}}
