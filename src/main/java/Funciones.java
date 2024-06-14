import java.sql.*;

public class Funciones {

    public static void ejecutarConsultarTodos(Connection connection ) {
        String query = "SELECT * FROM articulo"; // Reemplaza 'tu_tabla' por el nombre de tu tabla
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

           // Limpiar el JTextArea antes de agregar nuevos resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("idarticulo");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre + "\n");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



public static void ejecutarConsultaPorCodigo(Connection connection, int codigo) {

    String query = "SELECT * FROM articulo WHERE codigo = ?"; // Reemplaza 'tu_tabla' y 'codigo' por el nombre real de tu tabla y columna
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, codigo);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Procesar los resultados
        while (resultSet.next()) {
            // Supongamos que tu tabla tiene dos columnas: 'id' y 'nombre'
            int id = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            System.out.println("ID: " + id + ", Nombre: " + nombre);
        }

        // Cerrar recursos
        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}













/*
import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class Funciones {




    public static void ejecutarConsultaPorCodigo(Connection connection, int codigo) {

        String query = "SELECT * FROM articulo WHERE codigo = ?"; // Reemplaza 'tu_tabla' y 'codigo' por el nombre real de tu tabla y columna
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                // Supongamos que tu tabla tiene dos columnas: 'id' y 'nombre'
                int id = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }







    }

    public static void cerrarConexion(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ejecutarConsultarTodos(Connection connection) {


        Connection connection = getConnection();

        String query = "SELECT * FROM articulo"; // Reemplaza 'tu_tabla' por el nombre de tu tabla
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Limpiar el JTextArea antes de agregar nuevos datos


            // Procesar los resultados
            while (resultSet.next()) {
                // Supongamos que tu tabla tiene dos columnas: 'id' y 'nombre'
                int id = resultSet.getInt("idarticulo");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre + "\n");
            }

            // Cerrar recursos

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
*/