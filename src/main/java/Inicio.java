import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class Inicio extends JFrame {



    private JPanel mainPanel;

    private JButton buttonConsultar;
    private JTable tableResultados;

    public Inicio() {
        setContentPane(mainPanel);
        setTitle("Consultas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);



            // Acción del botón Consultar
            buttonConsultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarResultados();
                }
            });
        }

    private void mostrarResultados() {
        try (Connection connection = Conexion.getConnection()) {
            String query = "SELECT * FROM articulo";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre"}, 0);
            while (resultSet.next()) {
                int id = resultSet.getInt("idarticulo");
                String nombre = resultSet.getString("nombre");
                model.addRow(new Object[]{id, nombre});
            }

            // Asignar el modelo a la tabla
            tableResultados.setModel(model);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Inicio();
    }


}



