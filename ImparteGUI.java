import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Date;

@SuppressWarnings("serial")
public class ImparteGUI extends JFrame implements ActionListener
{
	private JTextField tfClaveProfesor, tfClaveCurso;
	private JButton    bRegistrar, bEliminar;
	private JTextArea  taDatos;
	public JPanel 	   p1, p2;
	
	private ImparteAD imparte = new ImparteAD(); 

	public ImparteGUI(){
		super("Impartir Curso");
		
		//Inicializar los atributos
		tfClaveProfesor 	= new JTextField();
		tfClaveCurso   		= new JTextField();
		taDatos    		= new JTextArea(12, 53);
		p1  	   		= new JPanel();
		p2  	   		= new JPanel();
		
		//Agregar los atributos a los paneles
		p1.setLayout(new GridLayout(5, 2));
		
		p1.add(new JLabel("Clave del Profesor"));
		p1.add(tfClaveProfesor);

		p1.add(new JLabel("Clave del Curso"));
		p1.add(tfClaveCurso);

		bRegistrar = new JButton("Dar de alta al curso");
		bRegistrar.addActionListener(this);
		p1.add(bRegistrar);
		
		bEliminar = new JButton("Dar de baja al curso");
		bEliminar.addActionListener(this);

		p1.add(bEliminar);
		p2.setLayout(new FlowLayout());
		
		p2.add(p1);
		p2.add(new JScrollPane(taDatos));

		add(p2);
		/* setSize(590,400);
		setVisible(true); */
	}
		
	public JPanel getPanel2()
	{
		return this.p2;
	}

	public void clearFields(){
		tfClaveProfesor.setText("");
		tfClaveCurso.setText("");
	}
	
	public void habilitarBotones(boolean value){
		bRegistrar.setEnabled(value); 
		bEliminar.setEnabled(value);
						
		tfClaveProfesor.setEnabled(value);
		tfClaveCurso.setEnabled(value);
	}
	
	private void mostrar(String str){
		StringTokenizer st = new StringTokenizer(str, "_");
					
		String claveProfesor = st.nextToken();
		String claveCurso = st.nextToken();
					
		tfClaveProfesor.setText(claveProfesor);
		tfClaveCurso.setText(claveCurso);
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
		
		String claveProfesor  = tfClaveProfesor.getText();
		String claveCurso     = tfClaveCurso.getText();

        String datos = "";
		
		if(claveProfesor.equals("")||claveCurso.equals(""))
			datos = "CAMPO_VACIO";
        else
        {
        	try
        	{
        		      		
    			// Verificar que no existan tokens en los strings, en este caso '_' que puedan llegar a comprometer el correcto funcionamiento del sistema
			     token = notTokenizer(claveProfesor); //Clave Profesor
			     if(token == false)
			     {
			     	token = notTokenizer(claveCurso); //Clave Curso
	        	 }
	       	     else
	        		 datos = "TOKEN";
	        	
        	}
        	catch(NumberFormatException nfe)
        	{
        		System.out.println("Error: " + nfe);
        		datos = "NO_NUMERICO";
        	}
        }
    
        return datos;
	}
	
	private void print(String str){
		
		if(str.equals("PROFESOR_VACIO")||(str.equals("CURSO_VACIO"))||(str.equals("CLAVE_NO_ENCONTRADA"))||(str.equals("CAMPO_VACIO"))||(str.equals("TOKEN"))||(str.equals("NO_NUMERICO"))||(str.equals("NEGATIVO"))||(str.equals("CLAVE_VACIA"))|| (str.equals("SEMESTRE_NO_REGISTRADO")) || (str.equals("CLAVE_DUPLICADA")) || (str.equals("CURSO_NO_REGISTRADO")) || (str.equals("DEPARTAMENTO_NO_ENCONTRADO")) || (str.equals("CLAVE_NO_REGISTRADA")))
		{
			if(str.equals("PROFESOR_VACIO"))
				taDatos.setText("El campo 'Clave Profesor' se encuentra vacío.");
				
			if(str.equals("CURSO_VACIO"))
				taDatos.setText("El campo 'Clave Curso' se encuentra vacío.");
				
			if(str.equals("CLAVE_CURSO_NO_ENCONTRADA"))
				taDatos.setText("La Clave del Curso '" + tfClaveCurso.getText() + "' no se encontró en la base de datos.");

			if(str.equals("CLAVE_PROFESOR_NO_ENCONTRADA"))
				taDatos.setText("La Clave del Profesor '" + tfClaveCurso.getText() + "' no se encontró en la base de datos.");
				
			if(str.equals("CAMPO_VACIO"))
				taDatos.setText("Todos los campos deben contener datos.");
				
			if(str.equals("TOKEN"))
				taDatos.setText("Los datos que se capturan no pueden contener un '_'");
			
			if(str.equals("IMPARTE_DUPLICADA"))
				taDatos.setText("El Profesor '" + tfClaveProfesor.getText() + "' ya se imparte ese curso. \nPor favor introduce otra clave de Profesor o clave de curso.");				
		}
		else
			taDatos.setText(str);
		
		if(str.equals("BD_VACIA"))
			taDatos.setText("No se ha registrado ningún artículo hasta el momento.");
			
	}
	
	
	/******************  ACTION PERFORMED  *********/ 
			
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bRegistrar)
		{
			//1) Obtener datos de los TextFields
            String datos = obtenerDatos();
            String resultado = "";
            
            //2) Comprobar que todos los campos cumplan con los diversos requisitos, y en caso de que estos no se respeten, evitar enviar los datos en ese estado
			if(datos.equals("CAMPO_VACIO")||datos.equals("TOKEN")||datos.equals("NO_NUMERICO")||datos.equals("NEGATIVO"))
				print(datos);
			else
			{
				//3) Enviar los datos a la clase AD a través del metodo registrarCurso()
			    resultado = imparte.imparteCurso(datos);
	
			    //4) Desplegar el resultado de la operación
			    print(resultado);
			    
			    if(!resultado.equals("IMPARTE_DUPLICADA"))
			    	//5) Quitar la información de los TextFields
			    	clearFields();	
			}
		}
		
		// if (e.getSource() == bConsultar){	
		// 	String datos = imparte.consultarCursos();
		// 	print(datos);
		// }

		// if (e.getSource() == bConsultarClave){
		// 	String resultado = consultar("CLAVE");
		// 	if(resultado.equals("CLAVE_VACIA")||(resultado.equals("ERROR"))||(resultado.equals("CLAVE_NO_REGISTRADA")))
		// 		print(resultado);
		// 	else{
		// 		//Colocar los datos en los TextFields
		// 		mostrar(resultado);	
		// 		print(resultado);
		// 	}	
		// }				
	}

	public static void main(String args[]){
		new ImparteGUI();
	}
}
