/*******************************************************/
/*** Programa de Intercambio de Mensajes con Sockets ***/
/***              Programa Cliente                  ***/
/*******************************************************/

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Conexion
{
  	private JTextField tfDatos = new JTextField();
 	  private JButton bEnvia;
  	private JTextArea taDatos = new JTextArea();
  	private JPanel p1 = new JPanel();
  	private JPanel p2 = new JPanel();
 
  	BufferedReader entradaDatos;
	  PrintWriter salidaDatos;
  	
  	String mensaje;
  	
  	Socket socket;
	
  	public void establecerConexion()
  	{
  	
  		try
  		{  	  
      		taDatos.append("Conexion en proceso...\n");
      		socket = new Socket("localhost",5001);

			// Preparar objetos de entrada y de salida
			entradaDatos = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salidaDatos = new PrintWriter(socket.getOutputStream(),true);
      		salidaDatos.flush();
  		}
  		catch (EOFException eof)
  		{
  	  		System.out.println("Conexion finalizada por el Server");
  		}
  		catch(IOException ioe)
  		{
  			System.out.println(ioe);
    	}
  	}
  	
  	public void cerrarConexion()
  	{
  		try
  		{
  			salidaDatos.close();
 	     	entradaDatos.close();
      		socket.close();  		
      	}
  		catch(IOException ioe)
  		{
  			System.out.println(ioe);
    	}
  	}
 
 
 	public String recibirDatos()
  	{
     	String str = "";
     	
     	try
     	{
       		str = entradaDatos.readLine();
     	}	
     	catch (IOException ioe)
  	 	{
  	   		taDatos.append("\nERROR al recibir el objeto");
  	 	}
     
     	return str;
  	}

  	public void enviarDatos(String str)
  	{
  		salidaDatos.println(str);
    	salidaDatos.flush();		
  	}

} 