import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlumnosAD{
	
    private Connection conexion;
    private Statement statement;
	private AlumnosDP alumnosDP;

	public String registrarAlumno(String datos){
		String insertAlumno = "";
        String respuesta = "";
        
        alumnosDP = new AlumnosDP(datos);
        
        /* Crear String con instrucción SQL */
        insertAlumno = "INSERT INTO Alumno VALUES("+ alumnosDP.toSQLString()+");";
        
        try {

            //1) Abrir la base de datos Banco
            statement = conexion.createStatement();
            
            //2) Capturar datos en la tabla correspondiente
            statement.executeUpdate(insertAlumno);
            
            //3) Cerrar la base de datos Banco
            statement.close();
            
            respuesta = "Datos: " + datos;
            System.out.println(conexion.nativeSQL(insertAlumno));
        }
        catch(SQLException sqle){
            	System.out.println("Error: " + sqle);
            	if(sqle.getErrorCode() == 1452)
            		respuesta = "ALUMNO_NO_REGISTRADO";
            	else
            		respuesta = "ALUMNO_DUPLICADO";
        }
        return respuesta;
	}
	    
}
