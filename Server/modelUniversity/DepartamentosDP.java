import java.util.*;

public class DepartamentosDP
{
	private int ndepto;
	private String nombre;
	private String claveAdministrador;
	private String fecha;
	
	//Constructors
	public DepartamentosDP()
	{
		this.ndepto      		= 0;
		this.nombre    		    = "";
		this.claveAdministrador = "";
		this.fecha		= "";
	}
	
	//String Tokenizer
	public DepartamentosDP(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos, "_");
		
			this.ndepto 		= Integer.parseInt(st.nextToken());
			this.nombre 	= st.nextToken();
			this.claveAdministrador		= st.nextToken();
			this.fecha		= st.nextToken();
	}
	
	//Accessors (Getters)
	public int getNdepto()
	{
		return this.ndepto;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public String getClaveAdministrador()
	{
		return this.claveAdministrador;
	}
	
	public String getFecha()
	{
		return this.fecha;
	}
	
	//Mutators(Setters)
	public void setNdepto(int ndepto)
	{
		this.ndepto = ndepto;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setClaveAdministrador(String claveAdministrador)
	{
		this.claveAdministrador = claveAdministrador;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}
	
	//Final String
	public String toString()
	{
		return this.ndepto+"_"+this.nombre+"_"+this.claveAdministrador+"_"+this.fecha;
	}
	
    public String toSQLString(){
        return "" + this.ndepto + ",'" + this.nombre+"','"+this.claveAdministrador+"','"+this.fecha+"'";
    }
}
