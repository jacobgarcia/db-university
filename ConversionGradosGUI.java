import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionGradosGUI extends JFrame implements ActionListener
{
	int sw;
	String str = null;
	
	private JLabel lDegrees;
	private JTextField tfGrados;
	private JButton bCentigrados, bFahrenheit, bSalir;
	private JTextArea taDatos;
	private JPanel panel1, panel2;
	
	private CalculoPD objeto = new CalculoPD();
	
	public ConversionGradosGUI()
	{
		super("Conversión de Grados");
		lDegrees = new JLabel("Grados = ");
		
		tfGrados = new JTextField(6);
		
		bCentigrados = new JButton("GC a GF");
		bCentigrados.addActionListener(this);
		
		bFahrenheit = new JButton("GF a GC");
		bFahrenheit.addActionListener(this);
		
		bSalir = new JButton("Salir");
		bSalir.addActionListener(this);
		
		taDatos = new JTextArea(10, 25);
		
		panel1 = new JPanel();
		
		panel2 = new JPanel();
		
		//Agregar atributos al Panel 1
		panel1.setLayout(new GridLayout(3, 2));
		panel1.add(lDegrees);
		panel1.add(tfGrados);
		panel1.add(bCentigrados);
		panel1.add(bFahrenheit);
		panel1.add(bSalir);
		
		//Agregar atributos al Panel 2
		panel2.setLayout(new FlowLayout());
		panel2.add(panel1);
		panel2.add(taDatos);
		
		
		//Visualizar Frame
		add(panel2);
		//setSize(350, 400);
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return this.panel2;
	}
	
	public void gradosCentigrados()
	{
		String stri;
		double graDos, res;
		stri = (tfGrados.getText());
		graDos = Double.parseDouble(stri);
		res = objeto.degrees(sw, graDos);
		if(sw == 1)
		{
			stri = ("Resultado = " +res + " °F");	
		}
		else
		{
			stri = ("Resultado = " +res + " °C");
		}
		taDatos.append(stri);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == bSalir)
			System.exit(0);
			
		if(event.getSource() == bCentigrados)
		{
			taDatos.setText("Conversión de Grados \n--------------------------------------------------------------------\n");
			try 
			{
				sw = 1;
				gradosCentigrados();
			}
			catch (NumberFormatException nfe) 
			{
				taDatos.append("ERROR: Debes teclear almenos un número, \nno se pueden introducir letras\n \n \n");
			}
		}
		
		if(event.getSource() == bFahrenheit)
		{
			taDatos.setText("Conversión de Grados \n--------------------------------------------------------------------\n");
			try 
			{
				sw = 2;
				gradosCentigrados();
			}
			catch (NumberFormatException nfe) 
			{
				taDatos.append("ERROR: Debes teclear almenos un número, \nno se pueden introducir letras\n \n \n");
			}
		}
	}
	
	public static void main(String args[])
	{
		new ConversionGradosGUI();
	}
}
