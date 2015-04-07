import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImparteAD{

	private Connection conexion;
    private Statement statement;
	private ImparteDP imparteDP;

	public String imparteCurso(String datos){
		String insertImparte="";
		String respuesta = "";

		imparteDP = new ImparteDP(datos);

		/*Crear String con instrucción SQL*/
		insertImparte = "INSERT INTO Toma VALUES("+imparteDP.toSQLString()+");";

		try{

			//1) Abrir la base de datos Universidad
			statement = conexion.createStatement();

			//2) Capturar datos en la tabla correspondiente
			statement.executeUpdate(insertImparte);

			//3) Cerrar la base de datos Banco
			statement.close();

		}
		catch(SQLException sqle){
			System.out.println("Error: "+sqle);
		}
		return respuesta;
	}
}