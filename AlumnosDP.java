import java.util.*;

public class AlumnosDP
{
	private String nombre;
	private String carrera;
	private int plan;
	private String domicilio;
	private String telefono;
	private String cursos;
	private String matricula;

	//Constructors
	public AlumnosDP()
	{
		this.nombre              = "";
		this.carrera              = "";
		this.plan             = 0;
		this.domicilio           = "";
		this.telefono         = "";
		this.cursos   = "";
		this.matricula               = "";
	}

	//String Tokenizer
	public AlumnosDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");

			this.nombre              = st.nextToken();
			this.carrera              = st.nextToken();
			this.plan             = Integer.parseInt(st.nextToken());
			this.domicilio           = st.nextToken();
			this.telefono         = st.nextToken();
			this.cursos   = st.nextToken();
			this.matricula               = st.nextToken();
	}

	//Accessors (Getters)
	public String getNombre()
	{
		return this.nombre;
	}

	public String getCarrera()
	{
		return this.carrera;
	}

	public int getPlan()
	{
		return this.plan;
	}

	public String getDomicilio()
	{
		return this.domicilio;
	}

	public String getTelefono()
	{
		return this.telefono;
	}

	public String getCursos()
	{
		return this.cursos;
	}

	public String getMatricula()
	{
		return this.matricula;
	}

	//Mutators (Setters)

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public void setPlan(int plan)
	{
		this.plan = plan;
	}

	public void setDomicilio(String domicilio)
	{
		this.domicilio = domicilio;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public void setCursos(String cursos)
	{
		this.cursos = cursos;
	}

	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	//Final String

	public String toString()
	{
		return this.nombre+"_"+this.carrera+"_"+this.plan+"_"+this.domicilio+"_"+this.telefono+"_"+this.cursos+"_"+this.matricula;
	}

	public String toSQLString(){
		return "" + this.nombre + ",'" + this.carrera + "','" + this.plan + "','" + this.domicilio + "','" + this.telefono + "','" + this.cursos + "','" + this.matricula+"'";
	}




}
