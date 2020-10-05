package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import entidad.Personas;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;

public class Modificar extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;

	
	public Modificar() {
		setLayout(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Personas persona= new Personas();
				
			}
		});
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

}
