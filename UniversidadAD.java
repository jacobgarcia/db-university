import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversidadAD{
	
    public static Connection conexion;
    private Statement statement;

	public UniversidadAD(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/Universidad?user=root");
            
			System.out.println("Conexión exitósa a la Base de Datos Universidad, Driver JDBC Tipo 4");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Error con el Driver JDBC: " + cnfe);
		}
		catch(InstantiationException ie){
			System.out.println("Error al crear la instancia: " + ie);
		}
		catch(IllegalAccessException iae){
			System.out.println("Error. Acceso ilegal a la base de datos: " + iae);
		}
		catch(SQLException sqle){
			System.out.println("Error SQL: " + sqle);
		
		}
	}
	
	public Connection getConnection(){
		return this.conexion;
	}
}
	
