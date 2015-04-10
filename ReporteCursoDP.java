import java.util.*;

public class ReporteCursoDP
{
	//Toma//
	private String matriculaToma;
	private String claveCurso;
	private int    grupo;

	// Curso //
	private String clave;
	private String nombre;
	private String semestre;
	private int noDepto;
	
	//Constructors
	public ReporteCursoDP()
	{
		this.matriculaToma = "";
		this.claveCurso    = "";
		this.grupo         = 0;
		this.clave         = "";
		this.nombre        = "";
		this.semestre      = "";
		this.noDepto       = 0;
	
	}
	
	//String Tokenizer
	public ReporteCursoDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");
		this.matriculaToma = st.nextToken();
		this.claveCurso    = st.nextToken();
		this.grupo         = Integer.parseInt(st.nextToken());
		this.clave         = st.nextToken();
		this.nombre        = st.nextToken();
		this.semestre      = st.nextToken();
		this.noDepto         = Integer.parseInt(st.nextToken());
	}

	//Mutators(Setters)
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

	public void setClave(String clave)
	{
		this.clave = clave;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setSemestre(String semestre)
	{
		this.semestre = semestre;
	}

	public void setNoDepto(int noDepto)
	{
		this.noDepto = noDepto;
	}
	
	//Final String
	public String toString()
	{
		return this.matriculaToma+"_"+this.claveCurso+"_"+this.grupo+"_"+this.clave+"_"+this.nombre+"_"+this.semestre+"_"+this.noDepto;
	}
}
