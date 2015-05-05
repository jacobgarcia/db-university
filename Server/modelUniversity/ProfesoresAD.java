import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfesoresAD{

	private Connection conexion = UniversidadAD.conexion;
    private Statement statement;
	private ProfesoresDP profesoresDP;

	public ProfesoresAD(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/Universidad?user=root&password=admin");
            
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


	public String consultarProfesoresSocket(){
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
                
                respuesta = respuesta + profesoresDP.toString() + "*";
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
    
    public String consultarPor(String tipoConsulta, String str){
	        ResultSet result = null;
	        String query = "";
	        String respuesta = "";
	        
	        if (tipoConsulta.equals("PROFESOR"))
	        	query = "SELECT * FROM Profesor WHERE clave = '" + str.toString() + "'";
	        	
	        if (tipoConsulta.equals("DEPARTAMENTO"))
	        	query = "SELECT * FROM Profesor WHERE ndepto = '" + str.toString() + "'";
	        	
	       	if (tipoConsulta.equals("SEXO"))
	        	query = "SELECT * FROM Profesor WHERE sexo = '" + str.toString() + "'";
	        
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
                
                respuesta = respuesta + profesoresDP.toString() + "*";
	            }
	            
	            if(respuesta == ""){
	            	if (tipoConsulta.equals("PROFESOR"))
		          		respuesta = "PROFESOR_NO_ENCONTRADO";
		          		
		          	if (tipoConsulta.equals("DEPARTAMENTO"))
		          		respuesta = "DEPARTAMENTO_NO_REGISTRADO";
		          		
		          	if (tipoConsulta.equals("SEXO"))
		          		respuesta = "SEXO_NO_REGISTRADO";
		        }
	            
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
