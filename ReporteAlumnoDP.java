import java.util.*;

public class ReporteAlumnoDP
{
	// ALumno //
	private String matricula;
	private String nombre;
	private String direccion;
	private String telefono;
	private String carrera;
	private int    plan;

	//Toma//
	private String matriculaToma;
	private String claveCurso;
	private int    grupo;
	
	//Constructors
	public ReporteAlumnoDP()
	{
		this.matricula     = "";
		this.nombre        = "";
		this.direccion     = "";
		this.telefono      = "";
		this.carrera       = "";
		this.plan          = 0;
		this.matriculaToma = "";
		this.claveCurso    = "";
		this.grupo         = 0;
	}
	
	//String Tokenizer
	public ReporteAlumnoDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");
		this.matricula     = st.nextToken();
		this.nombre        = st.nextToken();
		this.direccion     = st.nextToken();
		this.telefono      = st.nextToken();
		this.carrera       = st.nextToken();
		this.plan          = Integer.parseInt(st.nextToken());
		this.matriculaToma = st.nextToken();
		this.claveCurso    = st.nextToken();
		this.grupo         = Integer.parseInt(st.nextToken());
	}

	//Mutators(Setters)
	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public void setPlan(int plan)
	{
		this.plan = plan;
	}

	public void setMatriculaToma(String matriculaToma)
	{
		this.matriculaToma = matriculaToma;
	}

	public void setClaveCurso(String claveCurso)
	{
		this.claveCurso = claveCurso;
	}

	public void setGrupo(int grupo)
	{
		this.grupo = grupo;
	}
	
	//Final String
	public String toString()
	{
		return this.matricula+"_"+this.nombre+"_"+this.direccion+"_"+this.telefono+"_"+this.carrera+"_"+this.plan+"_"+this.matriculaToma+"_"+this.claveCurso+"_"+this.grupo;
	}
}
