package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import com.sun.glass.ui.TouchInputSupport;

import controlador.controlador;
import entidad.Personas;
import negocio.negocio_personas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agregar extends JPanel {
	private JTextField nombre_textField;
	private JTextField apellido_textField;
	private JTextField dni_textField;
	private JButton btnAgregar;
	
	
	public Agregar() {
		setToolTipText("Aceptar");
		setLayout(null);
		
		JLabel lblApellido = new JLabel("DNI");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(59, 143, 59, 17);
		add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(59, 46, 59, 17);
		add(lblNombre);
		
		JLabel label = new JLabel("Apellido");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(59, 95, 59, 17);
		add(label);
		
		nombre_textField = new JTextField();
		nombre_textField.setBounds(197, 46, 172, 20);
		add(nombre_textField);
		nombre_textField.setColumns(10);
		
		apellido_textField = new JTextField();
		apellido_textField.setColumns(10);
		apellido_textField.setBounds(197, 95, 172, 20);
		add(apellido_textField);
		
		dni_textField = new JTextField();
		dni_textField.setColumns(10);
		dni_textField.setBounds(197, 143, 172, 20);
		add(dni_textField);
		
		btnAgregar = new JButton("Aceptar");
	
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBounds(59, 195, 142, 29);
		add(btnAgregar);
	
		
		
		
	}

	public JTextField getNombre_textField() {
		return nombre_textField;
	}

	public void setNombre_textField(JTextField nombre_textField) {
		this.nombre_textField = nombre_textField;
	}

	public JTextField getApellido_textField() {
		return apellido_textField;
	}

	public void setApellido_textField(JTextField apellido_textField) {
		this.apellido_textField = apellido_textField;
	}

	public JTextField getDni_textField() {
		return dni_textField;
	}

	public void setDni_textField(JTextField dni_textField) {
		this.dni_textField = dni_textField;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public void mostrarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje);

	}
}
