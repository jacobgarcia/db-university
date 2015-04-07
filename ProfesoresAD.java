import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfesoresAD{

	private Connection conexion = UniversidadAD.conexion;
    private Statement statement;
	private ProfesoresDP profesoresDP;

	public String registrarProfesor(String datos){
		String insertProfesor="";
		String respuesta = "";

		profesoresDP = new ProfesoresDP(datos);

		/*Crear String con instrucción SQL*/
		insertProfesor = "INSERT INTO Profesor VALUES(" + profesoresDP.toSQLString() + ");";

		try{

			//1) Abrir la base de datos Universidad
			statement = conexion.createStatement();

			//2) Capturar datos en la tabla correspondiente
			statement.executeUpdate(insertProfesor);

			//3) Cerrar la base de datos Banco
			statement.close();
			
			respuesta = "Datos: " + datos;
            System.out.println(conexion.nativeSQL(insertProfesor));

		}
		catch(SQLException sqle){
			System.out.println("Error: " + sqle);
            	if(sqle.getErrorCode() == 1452)
            		respuesta = "DEPARTAMENTO_NO_REGISTRADO";
            	else
            		respuesta = "PROFESOR_DUPLICADO";
		}
		return respuesta;
	}
	
	public String consultarProfesores(){
        ResultSet result = null;
        String query = "";
        String respuesta = "";
        
        query = "SELECT * FROM Profesor";
        
        profesoresDP = new ProfesoresDP();

        try{
            //1) Abrir la base de datos Universidad
            statement = conexion.createStatement();
        
            //2) Procesar datos de la tabla resultante
            result = statement.executeQuery(query);
            
            while(result.next()){
                profesoresDP.setClave(result.getString(1));
                profesoresDP.setNombre(result.getString(2));
                profesoresDP.setDomicilio(result.getString(3));
                profesoresDP.setSalario(result.getInt(4));
                profesoresDP.setFNacimiento(result.getString(5));
                profesoresDP.setSexo(result.getString(6));
                profesoresDP.setClaveDepartamento(result.getInt(7));
                
                respuesta = respuesta + profesoresDP.toString() + "\n";
            }
            
            if(respuesta.equals(""))
            	return "BD_VACIA";
            
            //3) Cerra la base de datos banco
            statement.close();
            System.out.println(conexion.nativeSQL(query));
        }
        catch(SQLException sqle){
            System.out.println("Error: \n" + sqle);
            respuesta = "ERROR";
        }
        
        return respuesta;
    }
}
