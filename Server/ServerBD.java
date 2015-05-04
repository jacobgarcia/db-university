/*******************************************************/
/*** Programa de Intercambio de Mensajes con Sockets ***/
/***              Programa: Clase Servidor           ***/
/*******************************************************/

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;


public class ServerBD extends JFrame
{
	private JTextArea taDatos = new JTextArea();
	private JPanel p1 = new JPanel();
  	
	BufferedReader entradaDatos;
	PrintWriter salidaDatos;
	
	ServerSocket server;
  	Socket socket;
	
	String mensaje;

  private ProfesoresAD profesor = new ProfesoresAD();
  
  	// Constructor
	public ServerBD()
	{
    	super("Server");
    	
    	p1.setLayout(new GridLayout(1,1));
    	p1.add(new JScrollPane(taDatos));   
    	 
		add(p1);
		setSize(400,400);
		setVisible(true);
  	}


	private String recibirDatos()
  	{ 
     	String str = "";
     
     	try
     	{
			str = (String)entradaDatos.readLine();
     	}	
     	catch (IOException cnfx)
  	 	{
  	   		taDatos.append("\nERROR al recibir el objeto");
  	 	}
     
     	return str;
  	}


	private void enviarDatos(String str)
  	{
  		salidaDatos.println(str);
    	salidaDatos.flush();
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


	public void iniciarServer()
  	{
      String transaccion = "";
      String datos = "";
  					
  		try
  		{
  	  		server = new ServerSocket(5005,5);
  	  
  	  		while (true)
      		{
      			taDatos.append("\nSERVIDOR DE MENSAJES\nEsperando peticion de conexion...\n");
      			socket = server.accept();
      	
      			// Preparar objetos de entrada y de salida
				entradaDatos = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				salidaDatos  = new PrintWriter(socket.getOutputStream(),true);
				salidaDatos.flush();

 				transaccion = recibirDatos();

        if(transaccion.equals("consultarProfesores")){
          datos = profesor.consultarProfesoresSocket();
          enviarDatos(datos);
          cerrarConexion();
        }
      	
      			taDatos.append("\nTransacción realizada exitósamente " + transaccion + "\n"); 
      		}
  		}
  		catch (EOFException eof)
  		{
  	  		System.out.println("Conexion finalizada");
  		}
  		catch(IOException io)
  		{
  			io.printStackTrace();
    	}
  	}
  	

  	public static void main(String args[])
  	{
  		ServerBD aplicacion = new ServerBD();                          
    	aplicacion.iniciarServer();
  	}
} // Class Server