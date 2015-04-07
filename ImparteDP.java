import java.util.*;

public class ImparteDP
{
	private String claveProfesor;
	private String claveCurso;

	//Constructors
	public ImparteDP()
	{
		this.claveProfesor              = "";
		this.claveCurso              = "";
	}

	//String Tokenizer
	public ImparteDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");

			this.claveProfesor              = st.nextToken();
			this.claveCurso              = st.nextToken();
	}

	//Accessors (Getters)
	public String getClaveProfesor()
	{
		return this.claveProfesor;
	}

	public String getClaveCurso()
	{
		return this.claveCurso;
	}


	//Mutators (Setters)

	public void setClaveProfesor(String claveProfesor)
	{
		this.claveProfesor = claveProfesor;
	}

	public void setClaveCurso(String claveCurso)
	{
		this.claveCurso = claveCurso;
	}

	//Final String

	public String toString()
	{
		return this.claveProfesor+"_"+this.claveCurso; 
	}

	public String toSQLString(){
		return "" + this.claveProfesor + ",'" + this.claveCurso+"'"; 
	}




}