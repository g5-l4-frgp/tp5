package presentacion_vista;
import entidad.Personas;
import negocio.negocio_personas;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.controlador;

import java.util.List;

import javax.swing.JButton;


public class Listar extends JPanel {
private controlador controlador;
private negocio_personas pNeg = new negocio_personas();
private ArrayList<Personas> personasEnTabla = new ArrayList<Personas>();	
	
private JTable tablaPersonas;

public JTable getTablaPersonas() {
	return tablaPersonas;
}
public void setTablaPersonas(JTable tablaPersonas) {
	this.tablaPersonas = tablaPersonas;
}
public DefaultTableModel getModelPersonas() {
	return modelPersonas;
}
public void setModelPersonas(DefaultTableModel modelPersonas) {
	this.modelPersonas = modelPersonas;
}
public String[] getNombreColumnas() {
	return nombreColumnas;
}
public void setNombreColumnas(String[] nombreColumnas) {
	this.nombreColumnas = nombreColumnas;
}

private DefaultTableModel modelPersonas;
private String[] nombreColumnas = {"Nombre completo","Dni"};


	public Listar() {
		setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(15, 30, 413, 163);
		this.add(spPersonas);
	    
	    
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);

		
		spPersonas.setViewportView(tablaPersonas);
		
			
	}

	public void llenarTabla(List<Personas> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Personas p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String dni = p.getDni();
			String apellido = p.getApellido();
			Object[] fila = {apellido + ", "+ nombre , dni};
			this.getModelPersonas().addRow(fila);
		
		}
		
	}
}