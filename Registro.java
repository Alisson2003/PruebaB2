import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registro extends JFrame {
    private JPanel Panel1;
    private JTextField codigo;
    private JTextField nombre;
    private JTextField descripcion;
    private JTextField precio;
    private JTextField cantidad;
    private JTextField categoria;
    private JButton Busqueda;
    private JButton Registro;

    public Registro() {
        super("REGISTRO DE NUEVOS PRODUCTOS");
        setContentPane(Panel1);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        Registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(codigo.getText().equals("") || nombre.getText().equals("") || descripcion.getText().equals("") || precio.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Debe ingresar los campos");
                    JOptionPane.showMessageDialog(null, "El codigo de la producto es de " + codigo.getText());
                    JOptionPane.showMessageDialog(null, "El nombre de la producto es de " + nombre.getText());
                    JOptionPane.showMessageDialog(null, "El descripcion de la producto es de " + descripcion.getText());
                    JOptionPane.showMessageDialog(null, "El precio de la producto es de " + precio.getText());
                    JOptionPane.showMessageDialog(null, "La cantidad de la producto es de " + cantidad.getText());
                    JOptionPane.showMessageDialog(null, "La categoria de la producto es de " + categoria.getText());
                    JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO");
                }else{
                    JOptionPane.showMessageDialog(null, "PRODUCTO NO REGISTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        Busqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Busqueda busquedaFrame = new Busqueda();
                busquedaFrame.notifyAll();
                dispose();

                try (Connection connection = DriverManager.getConnection(String.valueOf(codigo))) {
                    JOptionPane.showMessageDialog(null,"CONECTANDO BASE DE DATOS DE LOS PRODUCTOS");
                    String query = "select * from usu where codigo_producto = '" + codigo + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        JOptionPane.showMessageDialog(null,resultSet.getString("codigo_producto"));}
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Panel1.add(Busqueda);

        setLocationRelativeTo(null);
    }
}
