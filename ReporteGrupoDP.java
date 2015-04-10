import java.util.*;

public class ReporteGrupoDP
{
	// Imparte //
	private String claveProfesor;
	private String claveCursoImparte;
	private int grupoImparte;

	//Toma//
	private String matricula;
	private String claveCursoToma;
	private int    grupoToma;
	
	//Constructors
	public ReporteGrupoDP()
	{
		this.claveProfesor     = "";
		this.claveCursoImparte = "";
		this.grupoImparte      = 0;
		this.matricula         = "";
		this.claveCursoToma    = "";
		this.grupoToma         = 0;
		
	}
	
	//String Tokenizer
	public ReporteGrupoDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");

		this.claveProfesor     = st.nextToken();
		this.claveCursoImparte = st.nextToken();
		this.grupoImparte      = Integer.parseInt(st.nextToken());
		this.matricula         = st.nextToken();
		this.claveCursoToma    = st.nextToken();
		this.grupoToma         = Integer.parseInt(st.nextToken());
	}

	//Mutators(Setters)
	public void setClaveProfesor(String claveProfesor)
	{
		this.claveProfesor = claveProfesor;
	}

	public void setClaveCursoImparte(String claveCursoImparte)
	{
		this.claveCursoImparte = claveCursoImparte;
	}

	public void setGrupoImparte(int grupoImparte)
	{
		this.grupoImparte = grupoImparte;
	}

	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public void setClaveCursoToma(String claveCursoToma)
	{
		this.claveCursoToma = claveCursoToma;
	}

	public void setGrupoToma(int grupoToma)
	{
		this.grupoToma = grupoToma;
	}
	
	//Final String
	public String toString()
	{
		return this.claveProfesor+"_"+this.claveCursoImparte+"_"+this.grupoImparte+"_"+this.matricula+"_"+this.claveCursoToma+"_"+this.grupoToma;
	}
}
