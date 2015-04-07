import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Date;

public class AlumnosGUI extends JFrame implements ActionListener
{
	private JTextField tfNombre, tfCarrera, tfPlan, tfDomicilio,tfTelefono, tfCursos, tfMatricula;
	private JButton    bRegistrar, bConsultar;
	private JTextArea  taDatos;
	public JPanel      p1,p2;

	private AlumnosAD alumnos = new AlumnosAD();

	public AlumnosGUI(){
		super("Alumnos");

		//Inicializar los atributos
		tfNombre       = new JTextField();
		tfCarrera       = new JTextField();
		tfPlan      = new JTextField();
		tfDomicilio    = new JTextField();
		tfTelefono  = new JTextField();
		tfCursos     = new JTextField();
		tfMatricula        = new JTextField();
		taDatos		   = new JTextArea(12, 63);
		p1			   = new JPanel();
		p2             = new JPanel();

		//Agregar los atributos a los paneles
		p1.setLayout(new GridLayout(9,2));

		p1.add(new JLabel("Nombre"));
		p1.add(tfNombre);

		p1.add(new JLabel("Grados"));
		p1.add(tfCarrera);

		p1.add(new JLabel("Salario"));
		p1.add(tfPlan);

		p1.add(new JLabel("Domicilio"));
		p1.add(tfDomicilio);

		p1.add(new JLabel("Teléfono"));
		p1.add(tfTelefono);

		p1.add(new JLabel("Cursos"));
		p1.add(tfCursos);

		p1.add(new JLabel("Matricula"));
		p1.add(tfMatricula);
		tfMatricula.setEditable(true);

		bRegistrar = new JButton("Registrar Alumno");
		bRegistrar.addActionListener(this);
		p1.add(bRegistrar);

		bConsultar = new JButton("Consultar Alumnos");
		bConsultar.addActionListener(this);
		p1.add(bConsultar);
		
		p2.setLayout(new FlowLayout());

		p2.add(p1);
		p2.add(new JScrollPane(taDatos));

		add(p2);
	}

	public JPanel getPanel2()
	{
		return this.p2;
	}

	public void clearFields(){
		tfNombre.setText("");
		tfCarrera.setText("");
		tfPlan.setText("");
		tfDomicilio.setText("");
		tfTelefono.setText("");
		tfCursos.setText("");
		tfMatricula.setText("");
	}

	public void habilitarBotones(boolean value){
		bRegistrar.setEnabled(value); 
		bConsultar.setEnabled(value);
	}

	private void mostrar(String str){
		StringTokenizer st = new StringTokenizer(str, "_");
					
		String nombre            = st.nextToken();
		String carrera            = st.nextToken();
		String plan	         = st.nextToken();
		String domicilio         = st.nextToken();
		String telefono       = st.nextToken();
		String cursos = st.nextToken();
		String matricula        = st.nextToken();
					
		tfNombre.setText(nombre);
		tfCarrera.setText(carrera);
		tfPlan.setText(plan);
		tfDomicilio.setText(domicilio);
		tfTelefono.setText(telefono);
		tfCursos.setText(cursos);
		tfMatricula.setText(matricula);
	}

	public boolean notTokenizer(String str){
		Character array[] = new Character[str.length()];
		int i = 0;
		boolean token = false;
		
		//1) Transformar el String en un arreglo de caracteres
	    for(i = 0; i < str.length(); i++) 
      		array[i] = new Character(str.charAt(i));
      		
      	//2) Verificar que no existan tokens en el string, en este caso '_' que puedan llegar a comprometer el correcto funcionamiento del sistema
      	i = 0; // Reinicializar contador
      	while((i < str.length())&&(token == false))
      	{
      		if(array[i] == '_')
      			token = true;
      		i++;
      	}
      	
      	return token;
	}

	private String obtenerDatos(){
		boolean token = false;
		int nmatricula;
		
		String nombre              = tfNombre.getText();
		String carrera              = tfCarrera.getText();
        String plan        	   = tfPlan.getText();
        String domicilio           = tfDomicilio.getText();
        String telefono         = tfTelefono.getText();
        String cursos   = tfCursos.getText();
        String matricula               = tfMatricula.getText();
        String datos = "";
		
		if(nombre.equals("")||carrera.equals("")||plan.equals("")||domicilio.equals("")||telefono.equals("")||cursos.equals("")||matricula.equals(""))
			datos = "CAMPO_VACIO";
        else
        {
        	try
        	{
        		// Comprobar que el campo de "Salario" sea numérico
        		// nplan = Integer.parseInt(plan);
        		
        		// Comprobar que el campo de "Salario" sea positivo
        		// if(nsalario < 0)
        		// 	datos = "NEGATIVO";	
        		// else
        		// {
        			// Verificar que no existan tokens en los strings, en este caso '_' que puedan llegar a comprometer el correcto funcionamiento del sistema
				     token = notTokenizer(telefono); //telefono
				     if(token == false)
				     {
				     	token = notTokenizer(nombre); //Nombre
				     	if(token == false)
					     	token = notTokenizer(domicilio); // Administrador
		        	 }
		        	 
		         	 if(token == false)
		        		 datos = nombre+"_"+carrera+"_"+plan+"_"+domicilio+"_"+telefono+"_"+cursos+"_"+matricula;
		       	     else
		        		 datos = "TOKEN";
	        	// }
        	}
        	catch(NumberFormatException nfe)
        	{
        		System.out.println("Error: " + nfe);
        		datos = "NO_NUMERICO";
        	}
        }
    
        return datos;
	}

		/*************  ACTION PERFORMED  *************/ 

		public void actionPerformed(ActionEvent e)
		{
			// 1) Obtener datos de los TextFields
			String datos = obtenerDatos();
			String resultado = "";

			// 2) Enviar los datos a la clase AD a través del metodo registrarProfesor()
			resultado = alumnos.registrarAlumno(datos);

			//3) Desplegar el resultado de la operacion
			taDatos.setText(resultado);
		}

}