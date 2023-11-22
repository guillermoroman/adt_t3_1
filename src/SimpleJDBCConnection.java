import java.sql.*;

public class SimpleJDBCConnection {

    public static void main(String[] args) {
        pruebaSencilla();
        prueba2();
    }

    public static void pruebaSencilla(){
        // URL de conexión a la base de datos

        String url = "jdbc:mysql://localhost:3306/dwes_t3";
        // "jdbc:mysql://localhost:3306/nombreDeTuBaseDeDatos";
        // Nombre de usuario y contraseña
        String usuario = "root";
        String contrasena = "";

        // Establecer la conexión
        try (Connection connection = DriverManager.getConnection(url, usuario, contrasena)) {
            if (connection != null) {
                System.out.println("Conectado con éxito a la base de datos.");
                // Aquí puedes realizar operaciones con la base de datos
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
    public static void prueba2(){
        // URL de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/dwes_t3";
        // Nombre de usuario y contraseña
        String usuario = "root";
        String contrasena = "";

        // Establecer la conexión
        try (Connection connection = DriverManager.getConnection(url, usuario, contrasena)) {
            if (connection != null) {
                System.out.println("Conectado con éxito a la base de datos.");

                // Crear un objeto Statement para enviar consultas a la base de datos
                Statement statement = connection.createStatement();

                // Consulta SQL para obtener la información de todas las pizzas
                String query = "SELECT * FROM pizzas";

                // Ejecutar la consulta y obtener el resultado
                ResultSet resultSet = statement.executeQuery(query);

                // Iterar sobre los resultados e imprimir la información de cada pizza
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    double coste = resultSet.getDouble("coste");
                    double precio = resultSet.getDouble("precio");
                    String ingredientes = resultSet.getString("ingredientes");

                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Coste: " + coste + ", Precio: " + precio + ", Ingredientes: " + ingredientes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}