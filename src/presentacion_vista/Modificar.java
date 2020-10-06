package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import entidad.Personas;
import negocio.negocio_personas;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;

public class Modificar extends JPanel {
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtDni;
	private JButton btnModificar;
    public JList<Personas> list;
	private DefaultListModel<Personas> modelModificar = new DefaultListModel<Personas>();
	private ArrayList<Personas> personasEnTabla;
	
	public JList<Personas> getList() {
		return list;
	}


	public void setList(JList<Personas> list) {
		this.list = list;
	}


	public DefaultListModel<Personas> getModelModificar() {
		return modelModificar;
	}


	public void setModelModificar(DefaultListModel<Personas> modelModificar) {
		this.modelModificar = modelModificar;
	}


	public Modificar() {
		setLayout(null);
		
		list = new JList();
		negocio_personas pNeg = new negocio_personas();
		this.personasEnTabla = (ArrayList<Personas>) pNeg.Obtener_lista_usuarios();
		llenarLista(personasEnTabla);
		list.setModel(modelModificar);
		
		list.setBounds(10, 11, 380, 187);
		add(list);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(280, 220, 107, 29);
		add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 220, 80, 24);
		add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 220, 80, 24);
		add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(190, 220, 80, 24);
		add(txtDni);

	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public JList<Personas> getJlist() {
		return list;
	}
	
	public void llenarLista(List<Personas> personasEnTabla) {
		this.getModelModificar().clear(); //borrar lista
	
		for (Personas p : personasEnTabla)
		{			
			this.modelModificar.addElement(p);		
		}
		
	}


	public void mostrarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	

}
