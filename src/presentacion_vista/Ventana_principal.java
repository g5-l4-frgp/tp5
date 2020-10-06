package presentacion_vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.controlador;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_principal extends JFrame {

	private JPanel contentPane;
	public Ventana_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				
				Agregar pan_agregar = new Agregar();
				contentPane.add(pan_agregar);
				contentPane.repaint();
				contentPane.revalidate();
				controlador controlador =new controlador(pan_agregar);
				
				
			}
		});
		mnPersona.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				
				Modificar pan_modificar = new Modificar();
				
				contentPane.add(pan_modificar);
				contentPane.repaint();
				contentPane.revalidate();
				controlador controlador = new controlador(pan_modificar);
				
			}
		});
		mnPersona.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				
				Eliminar pan_eliminar = new Eliminar();
				
				contentPane.add(pan_eliminar);
				contentPane.repaint();
				contentPane.revalidate();
				controlador controlador =new controlador(pan_eliminar);
				
			}
		});
		mnPersona.add(mntmEliminar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				
				Listar pan_listar = new Listar();
				
				contentPane.add(pan_listar);
				contentPane.repaint();
				contentPane.revalidate();
				controlador controlador =new controlador(pan_listar);	
			}
		});
		mnPersona.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
