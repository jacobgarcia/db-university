import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReporteGrupoAD{
	
    private Connection conexion = UniversidadAD.conexion;
    private Statement statement;
    private ReporteGrupoDP reporteGrupoDP;

	public String reporteDelGrupo(String claveProfesor, String claveCurso, String grupo){
        ResultSet result = null;
        String query = "";
        String respuesta = "";
        
        query = "SELECT * FROM Imparte JOIN Toma ON Imparte.clave_curso = Toma.clave_curso WHERE Imparte.clave_curso = '"+claveCurso+"' AND Imparte.clave_profesor = '"+claveProfesor+"' AND Imparte.grupo = "+grupo+"";
        
        reporteGrupoDP = new ReporteGrupoDP();

        try{
            
            //1) Abrir la base de datos Universidad
            statement = conexion.createStatement();
        
            //2) Procesar datos de la tabla resultante
            result = statement.executeQuery(query);
            
            while(result.next()){
                reporteGrupoDP.setClaveProfesor(result.getString(1));
                reporteGrupoDP.setClaveCursoImparte(result.getString(2));
                reporteGrupoDP.setGrupoImparte(result.getInt(3));
                reporteGrupoDP.setMatricula(result.getString(4));
                reporteGrupoDP.setClaveCursoToma(result.getString(5));
                reporteGrupoDP.setGrupoToma(result.getInt(6));
                                
                respuesta = respuesta + reporteGrupoDP.toString() + "\n";
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
