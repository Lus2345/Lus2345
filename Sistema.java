package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sistema {
	private static final String URL = "jdbc:mysql://localhost:3306/sistem_matriculas"; // Cambiado el puerto y la base de datos

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

		 try {
			 connection = DriverManager.getConnection(URL);
	            System.out.println("Conexión exitosa a la base de datos.");

	            statement = connection.createStatement();
	            
	            String sql = "SELECT * FROM CLIENTE";
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                String telefono = resultSet.getString("telefono_adm");
	                String correo = resultSet.getString("correo_adm");
	                String nombre = resultSet.getString("nombre");
	                String cliente = resultSet.getString("cargo");

	                System.out.println( "Cliente: " + cliente + ", Nombre: " + nombre + ", Telefono: " + telefono +
	                		", Correo: " + correo);
	            }
	            resultSet.close();

	        } catch (SQLException e) {
	            System.err.println("Error de conexión: " + e.getMessage());
	        } finally {
	            try {
	                if (statement != null) statement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                System.err.println("Error al cerrar la conexión: " + e.getMessage());
	            }
	        }
	    }
	}
