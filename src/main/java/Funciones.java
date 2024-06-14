import java.sql.*;

public class Funciones {

    public static void ejecutarConsultarTodos() {
        try (Connection connection = Conexion.getConnection()) {
            String query = "SELECT * FROM articulo";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("idarticulo");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ejecutarConsultarPorCodigo(String codigo) {
        try (Connection connection = Conexion.getConnection()) {
            String query = "SELECT * FROM tu_tabla WHERE codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            } else {
                System.out.println("No se encontró el registro con código: " + codigo);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ejecutarEliminarPorCodigo(String codigo) {
        try (Connection connection = Conexion.getConnection()) {
            String query = "DELETE FROM tu_tabla WHERE codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, codigo);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el registro con código: " + codigo);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






















/*
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