import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReporteAlumnoAD{
	
    private Connection conexion = UniversidadAD.conexion;
    private Statement statement;
    private ReporteAlumnoDP reporteAlumnoDP;

	public String reporteDelAlumno(String matricula){
        ResultSet result = null;
        String query = "";
        String respuesta = "";
        
        query = "SELECT * FROM Alumno JOIN Toma ON '"+matricula+"' = Toma.matricula";
        
        reporteAlumnoDP = new ReporteAlumnoDP();

        try{
            
            //1) Abrir la base de datos Universidad
            statement = conexion.createStatement();
        
            //2) Procesar datos de la tabla resultante
            result = statement.executeQuery(query);
            
            while(result.next()){
                reporteAlumnoDP.setMatricula(result.getString(1));
                reporteAlumnoDP.setNombre(result.getString(2));
                reporteAlumnoDP.setDireccion(result.getString(3));
                reporteAlumnoDP.setTelefono(result.getString(4));
                reporteAlumnoDP.setCarrera(result.getString(5));
                reporteAlumnoDP.setPlan(result.getInt(6));
                reporteAlumnoDP.setMatriculaToma(result.getString(7));
                reporteAlumnoDP.setClaveCurso(result.getString(8));
                reporteAlumnoDP.setGrupo(result.getInt(9));
                
                respuesta = respuesta + reporteAlumnoDP.toString() + "\n";
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
