import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReporteCursoAD{
	
    private Connection conexion = UniversidadAD.conexion;
    private Statement statement;
    private ReporteCursoDP reporteCurso;

	public String reporteDelCurso(String claveCurso){
        ResultSet result = null;
        String query = "";
        String respuesta = "";

        query = "SELECT * FROM Toma JOIN Curso ON clave_curso = clave WHERE clave = '"+claveCurso+"'";
        
        reporteCurso = new ReporteCursoDP();

        try{
            
            //1) Abrir la base de datos Universidad
            statement = conexion.createStatement();
        
            //2) Procesar datos de la tabla resultante
            result = statement.executeQuery(query);
            
            while(result.next()){
                reporteCurso.setMatriculaToma(result.getString(1));
                reporteCurso.setClaveCurso(result.getString(2));
                reporteCurso.setGrupo(result.getInt(3));
                reporteCurso.setClave(result.getString(4));
                reporteCurso.setNombre(result.getString(5));
                reporteCurso.setSemestre(result.getString(6));
                reporteCurso.setNoDepto(result.getInt(7));
                                
                respuesta = respuesta + reporteCurso.toString() + "\n";
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
