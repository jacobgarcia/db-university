/*
 * GradosIUG.java
 *
 *  Created on: 01/04/2015
 *		Project #2
 *      Authors: Mario Jacob García Navarro & Luis Arturo Mendoza Reyes. All Rights Reserved 2015.
 *		IN THIS PROJECT A "UNIVERSITY SYSTEM" WLL BE SIMULATED.
 *		WE WILL BE CREATING A DATA BASE & ADDING ELEMENTS TO IT. OTHER TASKS WILL BE DONE THROUGH.
 *		IT IS MAIN PURPOSE IS USE SQL METHODS IN ORDER TO UNDERSTAND HOW OPERATIONS OF 
 *		RELATIONAL ALGEBRA WORKS.
 */
 

import javax.swing.*;
import java.awt.event.*;

public class UniversidadGUI extends JFrame implements ActionListener
{
	private JMenuBar mbProyecto;
	private JMenu mProfesores, mDepartamentos, mAlumnos, mCursos;
	private JMenuItem miRegistroProfesor, miFormacion, miRegistroDepartamento, miAsignar, miRegistroAlumno, miInscripcion, miRegistroCurso;
	private JPanel panel;
	private JMenuItem miEspiralRectangulo, miEspiralCirculo, miCubo, miEspiralCubo, miArticulos;
	
	private UniversidadAD universidad = new UniversidadAD();
	private GradosIUG grados = new GradosIUG();
	private DepartamentosIUG departamentos = new DepartamentosIUG();
	private CursosIUG cursos = new CursosIUG();
	private ProfesoresGUI profesor = new ProfesoresGUI();
	private AlumnosGUI alumno = new AlumnosGUI();
	private ImparteGUI imparte = new ImparteGUI();
	private TomaGUI toma = new TomaGUI();
	
	public UniversidadGUI()
	{
		super("Universidad Tecnológico");
		
		//Se Crean Atributos
		mbProyecto = new JMenuBar();
		
		mProfesores = new JMenu("Profesores");
		miRegistroProfesor = new JMenuItem("Registro de Profesores");
		miRegistroProfesor.addActionListener(this);
		
		miFormacion = new JMenuItem("Formación Académica");
		miFormacion.addActionListener(this);
		
		miAsignar = new JMenuItem("Asignación de Cursos");
		miAsignar.addActionListener(this);
					
	
		
		mDepartamentos = new JMenu("Departamentos");
		miRegistroDepartamento = new JMenuItem("Registro de Departamentos");
		miRegistroDepartamento.addActionListener(this);
		
		
		
		mAlumnos = new JMenu("Alumnos");
		miRegistroAlumno = new JMenuItem("Registro de Alumnos");
		miRegistroAlumno.addActionListener(this);
		
		miInscripcion = new JMenuItem("Inscripción de Cursos");
		miInscripcion.addActionListener(this);
		
		
		
		mCursos = new JMenu("Cursos");
		miRegistroCurso = new JMenuItem("Registro de Cursos");
		miRegistroCurso.addActionListener(this);
		
		
		//Panel
		panel = new JPanel();
		
		//Adicionar Objetos al MenuBar, Menú "Profesores"
		mDepartamentos.add(miRegistroDepartamento);
		mDepartamentos.add(miAsignar);
		
		mAlumnos.add(miRegistroAlumno);
		mAlumnos.add(miInscripcion);
		
		mProfesores.add(miRegistroProfesor);
		mProfesores.add(miFormacion);
		mProfesores.add(miAsignar);
		
		mCursos.add(miRegistroCurso);

		mbProyecto.add(mProfesores);
		mbProyecto.add(mDepartamentos);
		mbProyecto.add(mCursos);
		mbProyecto.add(mAlumnos);
		
		//2) Visualizar Frame
		setJMenuBar(mbProyecto);
		setSize(720, 400);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == miFormacion)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = grados.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miRegistroDepartamento)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = departamentos.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miRegistroCurso)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = cursos.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miRegistroProfesor)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = profesor.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miRegistroAlumno)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = alumno.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}

		if(event.getSource() == miAsignar)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = imparte.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(event.getSource() == miInscripcion)
		{
			if(panel != null)
			{
				panel.setVisible(false);
			}
			panel = toma.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
	}
	
	public static void main(String args[])
	{
		UniversidadGUI proyecto = new UniversidadGUI();
		proyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
