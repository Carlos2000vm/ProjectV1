import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/db_ventas";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fallo al cargar el driver MySQL.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo al establecer la conexión con la base de datos.");
        }
        return connection;
    }
}