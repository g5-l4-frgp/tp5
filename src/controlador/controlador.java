package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;


import presentacion_vista.Agregar;
import presentacion_vista.Listar;
import presentacion_vista.Modificar;
import presentacion_vista.Ventana_principal;
import presentacion_vista.Eliminar;
import negocio.negocio_personas;
import entidad.Personas;
public class controlador implements ActionListener {

	private Ventana_principal Ventana_principal;
	private Modificar VentanaModificar;
	private Agregar ventanaAgregar;
	private Listar ventanaListar;
	private Eliminar ventanaEliminar;
	private negocio_personas pNeg= new negocio_personas();
	private ArrayList<Personas> listaPersonas;
	private DefaultListModel<Personas> mlist;
    private JList<Personas> list;
    private Personas persona = new Personas();

	public controlador(Agregar ventanaAgregar) 
	{
		this.ventanaAgregar=ventanaAgregar;
		this.ventanaAgregar.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
	}

	public controlador(Listar pan_listar) {
		
		this.ventanaListar = pan_listar;
		this.refrescarTabla();
	}
	
	public controlador(Eliminar pan_eliminar) {
		this.ventanaEliminar = pan_eliminar;
		this.ventanaEliminar.getBtnEliminar().addActionListener(a->Eliminar(a));
		// TODO Auto-generated constructor stub
	}
	
   private void Eliminar(ActionEvent a) {
	   DefaultListModel modelo = (DefaultListModel) this.ventanaEliminar.getModelEliminar();
	   int index = this.ventanaEliminar.getList().getSelectedIndex();
	   Personas personas = (Personas)modelo.getElementAt(index);
	   boolean estado = pNeg.EliminarPersona(personas.getDni());
	   String mensaje;
		if(estado == true)
		{
			mensaje="Persona Eliminada";
			modelo.remove(index);
		}
		
		else
			mensaje="Persona no pudo ser modificada";
		
		ventanaEliminar.mostrarMensaje(mensaje);
	   
	}
   

   public controlador(Modificar ventanaModificar) {
	
	   this.VentanaModificar = ventanaModificar;
	   DefaultListModel modelo = (DefaultListModel) this.VentanaModificar.getModelModificar();
	   this.VentanaModificar.list.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent evt) {
			   JList list = (JList)evt.getSource();
			   if (evt.getClickCount() == 1){
				   int index = VentanaModificar.getList().getSelectedIndex();
				   Personas personas = (Personas)modelo.getElementAt(index);
				   VentanaModificar.txtApellido.setText(personas.getApellido());
				   VentanaModificar.txtNombre.setText(personas.getNombre());
				   VentanaModificar.txtDni.setText(personas.getDni());
			   }
		   }
	});
	   this.VentanaModificar.getBtnModificar().addActionListener(a->EventoModificar(a));
		
   }

	private void ventanaAgregarPersona(ActionEvent a) {
		String nombre = this.ventanaAgregar.getNombre_textField().getText();
		String dni = ventanaAgregar.getDni_textField().getText();
		String apellido = ventanaAgregar.getApellido_textField().getText();
		Personas nuevaPersona = new Personas(dni,nombre,apellido);
		
		int estado = pNeg.AgrerarUsuario(nuevaPersona);
		String mensaje;
		if(estado>0)
		{
			mensaje="Persona agregada con exito";
			this.ventanaAgregar.getNombre_textField().setText("");
			ventanaAgregar.getDni_textField().setText("");
			ventanaAgregar.getApellido_textField().setText("");
			
		}
		
		else
			mensaje="Persona no agregada, complete todos los campos";
		
		this.ventanaAgregar.mostrarMensaje(mensaje);
		
	
	}
	
	
	private void EventoModificar(ActionEvent a) {
		persona.setNombre(this.VentanaModificar.getTxtNombre().getText());
		persona.setDni(VentanaModificar.getTxtDni().getText());
		persona.setApellido(VentanaModificar.getTxtApellido().getText());
		boolean estado = pNeg.ModificarPersona(persona);
		String mensaje;
		if(estado == true)
		{
			mensaje="Persona Modificada";
			VentanaModificar.txtApellido.setText("");
			VentanaModificar.txtNombre.setText("");
			VentanaModificar.txtDni.setText("");
	
		}
		
		else
			mensaje="Persona no pudo ser modificada";
		
		VentanaModificar.mostrarMensaje(mensaje);
	}

	
	
	public void refrescarTabla()
	{
		this.listaPersonas = (ArrayList<Personas>) pNeg.Obtener_lista_usuarios();
		this.ventanaListar.llenarTabla(listaPersonas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
