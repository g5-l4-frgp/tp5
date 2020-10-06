package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JTable;

import entidad.Personas;
import negocio.negocio_personas;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Eliminar extends JPanel {

	private negocio_personas pNeg = new negocio_personas();
	private ArrayList<Personas> personasEnTabla = new ArrayList<Personas>();
	private JButton btnEliminar = new JButton("Eliminar");
	JList<Personas> list = new JList<Personas>();
	public JList<Personas> getList() {
		return list;
	}

	public void setList(JList<Personas> list) {
		this.list = list;
	}

	private DefaultListModel<Personas> modelEliminar = new DefaultListModel<Personas>();
	public DefaultListModel<Personas> getModelEliminar() {
		return modelEliminar;
	}

	public void setModelEliminar(DefaultListModel<Personas> modelEliminar) {
		this.modelEliminar = modelEliminar;
	}



	public JButton getBtnEliminar() {
		return btnEliminar;
	}



	public ArrayList<Personas> getPersonasEnTabla() {
		return personasEnTabla;
	}



	public void setPersonasEnTabla(ArrayList<Personas> personasEnTabla) {
		this.personasEnTabla = personasEnTabla;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	/**
	 * Create the panel.
	 */
	public Eliminar() {
		setLayout(null);
		
		JLabel lblEliminar = new JLabel("Eliminar usuarios");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEliminar.setBounds(144, 33, 111, 14);
		add(lblEliminar);
		list.setBounds(80, 54, 270, 190);
		add(list);
		this.personasEnTabla = (ArrayList<Personas>) pNeg.Obtener_lista_usuarios();
		llenarLista(personasEnTabla);
		list.setModel(modelEliminar);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		btnEliminar.setBounds(129, 253, 126, 30);
		add(btnEliminar);

	}
	
	
	
	
	public void llenarLista(List<Personas> personasEnTabla) {
		this.getModelEliminar().clear(); //borrar lista
	
		for (Personas p : personasEnTabla)
		{			
			this.modelEliminar.addElement(p);		
		}
		
	}

	public void mostrarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje);
		
	}

}
