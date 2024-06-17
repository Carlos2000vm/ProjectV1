import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Inicio extends JFrame {



    private JPanel mainPanel;

    private JTextField textFieldNombre;
    private JButton buttonConsultar;
    private JTable tableResultados;
    private JTextField textFieldCodigo;

    public Inicio() {
        setContentPane(mainPanel);
        setTitle("Consultas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1030, 800);
        setLocationRelativeTo(null);
        setVisible(true);







        // Acción del botón Consultar
            buttonConsultar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    consultaCodigoNombre();


                }
            });
        }

    private void mostrarResultados() {
        try (Connection connection = Conexion.getConnection()) {
            String query = "SELECT * FROM articulo";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Codigo","stock", "descripcion"}, 0);
            while (resultSet.next()) {
                int id = resultSet.getInt("idarticulo");
                String nombre = resultSet.getString("nombre");
                String Codigo = resultSet.getString("codigo");
                String stock = resultSet.getString("stock");
                String descripcion = resultSet.getString("descripcion");
                model.addRow(new Object[]{id, nombre, Codigo, stock, descripcion});
            }


            // Asignar el modelo a la tabla
            tableResultados.setModel(model);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void consultaCodigoNombre() {
        String codigo = textFieldCodigo.getText().trim();
        String nombre = textFieldNombre.getText().trim();
        StringBuilder query = new StringBuilder("SELECT * FROM articulo");

        boolean hasCodigo = !codigo.isEmpty();
        boolean hasNombre = !nombre.isEmpty();

        if (hasCodigo || hasNombre) {
            query.append(" WHERE");
            if (hasCodigo) {
                query.append(" codigo = ").append(codigo);
            }
            if (hasCodigo && hasNombre) {
                query.append(" AND");
            }
            if (hasNombre) {
                query.append(" nombre LIKE '%").append(nombre).append("%'");
            }
        }

        try (Connection connection = Conexion.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query.toString());

            // Crear modelo de tabla
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre","Codigo","stock", "descripcion"}, 0);
            while (resultSet.next()) {
                int id = resultSet.getInt("idarticulo");
                String nombreResult = resultSet.getString("nombre");
                String Codigo = resultSet.getString("codigo");
                String stock = resultSet.getString("stock");
                String descripcion = resultSet.getString("descripcion");

                model.addRow(new Object[]{id, nombreResult,codigo,stock,descripcion });
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






/*

private void mostrarResultados() {
    try (Connection connection = Conexion.getConnection()) {
        String query = "SELECT * FROM articulo";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Codigo","stock", "descripcion"}, 0);
        while (resultSet.next()) {
            int id = resultSet.getInt("idarticulo");
            String nombre = resultSet.getString("nombre");
            String Codigo = resultSet.getString("codigo");
            String stock = resultSet.getString("stock");
            String descripcion = resultSet.getString("descripcion");
            model.addRow(new Object[]{id, nombre, Codigo, stock, descripcion});
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
*/