import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartamentosAD{
	
    private Connection conexion = UniversidadAD.conexion;
    private Statement statement;
	private DepartamentosDP departamentosDP;
	
	public String registrarDepartamento(String datos){
		String insertDepartamento = "";
        String respuesta = "";
        
        departamentosDP = new DepartamentosDP(datos);
        
        /* Crear String con instrucción SQL */
        insertDepartamento = "INSERT INTO Departamento VALUES(" + departamentosDP.toSQLString() + ");";
        
        try {
            //1) Abrir la base de datos Banco
            statement = conexion.createStatement();
            
            //2) Capturar datos en la tabla correspondiente
            statement.executeUpdate(insertDepartamento);
            
            //3) Cerrar la base de datos Banco
            statement.close();
            
            respuesta = "Datos: " + datos;
            System.out.println(conexion.nativeSQL(insertDepartamento));
        }
        catch(SQLException sqle){
            	System.out.println("Error: " + sqle);
            	if(sqle.getErrorCode() == 1452)
            		respuesta = "PROFESOR_NO_REGISTRADO";
            	else
            		respuesta = "DEPARTAMENTO_DUPLICADO";
        }
        return respuesta;
	}
	
	public String consultarDepartamentos(){
        ResultSet result = null;
        String query = "";
        String respuesta = "";
        
        query = "SELECT * FROM Departamento";
        
        departamentosDP = new DepartamentosDP();
        try{
            
            //1) Abrir la base de datos Universidad
            statement = conexion.createStatement();
        
            //2) Procesar datos de la tabla resultante
            result = statement.executeQuery(query);
            
            while(result.next()){
                departamentosDP.setNdepto(result.getInt(1));
                departamentosDP.setNombre(result.getString(2));
                departamentosDP.setClaveAdministrador(result.getString(3));
                departamentosDP.setFecha(result.getString(4));
                
                respuesta = respuesta + departamentosDP.toString() + "\n";
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
	        
	        if (tipoConsulta.equals("ADMINISTRADOR"))
	        	query = "SELECT * FROM Departamento WHERE clave_admin = '" + str.toString() + "'";
	        
	        if (tipoConsulta.equals("NOMBRE"))
	        	query = "SELECT * FROM Departamento WHERE nombre = '" + str.toString() + "'";
	        
	        if (tipoConsulta.equals("DEPARTAMENTO"))
	      	    query = "SELECT * FROM Departamento WHERE ndepto = '" + str.toString() + "'";
	        
	        departamentosDP = new DepartamentosDP();
	        try{
	            
	            //1) Abrir la base de datos Universidad
	            statement = conexion.createStatement();
	            
	            //2) Procesar datos de la tabla resultante
	            result = statement.executeQuery(query);
	            
	            while(result.next()){
	                departamentosDP.setNdepto(result.getInt(1));
	                departamentosDP.setNombre(result.getString(2));
	                departamentosDP.setClaveAdministrador(result.getString(3));
	                departamentosDP.setFecha(result.getString(4));
	                
	                respuesta = respuesta + departamentosDP.toString() + "\n";
	            }
	            
	            if(respuesta == ""){
		            if (tipoConsulta.equals("ADMINISTRADOR"))
		                respuesta = "ADMINISTRADOR_NO_REGISTRADO";
		                
		            if (tipoConsulta.equals("NOMBRE"))
		                respuesta = "NOMBRE_NO_REGISTRADO";
		            
		            if (tipoConsulta.equals("DEPARTAMENTO"))    
		                respuesta = "DEPARTAMENTO_NO_ENCONTRADO";
	            }
	            
	            //3) Cerra la base de datos banco
	            statement.close();
	            System.out.println(conexion.nativeSQL(query));
	        }
	        
	        catch(SQLException sqle){
	            System.out.println("Error: \n" + sqle);
	            respuesta = "No se pudo realizar la consulta";
	        }
	        
	        return respuesta;
	    }
	    
}
