import java.util.*;

public class TomaDP
{
	private String matricula;
	private String claveCurso;

	//Constructors
	public TomaDP()
	{
		this.matricula = "";
		this.claveCurso    = "";
	}

	//String Tokenizer
	public TomaDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");

			this.matricula = st.nextToken();
			this.claveCurso    = st.nextToken();
	}

	//Accessors (Getters)
	public String getMatricula()
	{
		return this.matricula;
	}

	public String getClaveCurso()
	{
		return this.claveCurso;
	}


	//Mutators (Setters)

	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public void setClaveCurso(String claveCurso)
	{
		this.claveCurso = claveCurso;
	}

	//Final String

	public String toString()
	{
		return this.matricula+"_"+this.claveCurso; 
	}

	public String toSQLString(){
		return "'" + this.matricula + "','" + this.claveCurso+"'"; 
	}
}
