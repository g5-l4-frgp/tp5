package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JOptionPane;

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
//	public controlador(Ventana_principal vista,negocio_personas pNeg,Listar ventanaListar,Agregar ventanaAgregar
//) {
//		this.Ventana_principal = vista;
//		this.pNeg = pNeg;
//		this.ventanaAgregar.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
//
//
//	}
	public controlador(Agregar ventanaAgregar) 
				{
					this.ventanaAgregar=ventanaAgregar;
					this.ventanaAgregar.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
				}

	public controlador(Listar pan_listar) {
		
		this.ventanaListar=pan_listar;
		this.refrescarTabla();
	}
	public controlador(presentacion_vista.Eliminar pan_eliminar) {
		this.ventanaEliminar=pan_eliminar;
		this.ventanaEliminar.getBtnEliminar().addActionListener(a->ventanaEliminar(a));
		// TODO Auto-generated constructor stub
	}

	
   public controlador(Modificar ventanaModificar) {
	
		this.VentanaModificar=ventanaModificar;
		this.VentanaModificar.getBtnModificar().addActionListener(a->EventoModificar(a));
		this.VentanaModificar.getJlist();
		
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
	

	public void ventanaEliminar(ActionEvent s)
	{
		boolean estado=false;
		int[] filasSeleccionadas =  ObtenerDni_de_cadena(this.ventanaEliminar.getPersonasEnTabla().getSelectedValue().toString())))
		for (int fila : filasSeleccionadas)
		{
			estado = pNeg.delete(this.personasEnTabla.get(fila));
			if(estado==true)
			{
				String mensaje="Persona eliminada con exito";
				this.ventanaPrincipal.mostrarMensaje(mensaje);
			}
		}
		this.refrescarTabla();

      private void cargarModificar() {
		
		pNeg= new negocio_personas();
		listaPersonas= new ArrayList<Personas>();
		listaPersonas= pNeg.Obtener_lista_usuarios();
		for(Personas p : listaPersonas) {
			 Personas x= new Personas();
			 x.setNombre(p.getNombre());
			 x.setApellido(p.getApellido());
			 x.setDni(p.getDni());
			 mlist.addElement(x);
		
		}
		
	      list.setModel(mlist);
		
	}
	
	private void EventoModificar(ActionEvent a) {
		String nombre= this.VentanaModificar.getTxtNombre().getText();
		String dni= VentanaModificar.getTxtDni().getText();
		String apellido= VentanaModificar.getTxtApellido().getText();
		

	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (pNeg.EliminarPersona(ObtenerDni_de_cadena(list.getSelectedValue().toString())))
			JOptionPane.showMessageDialog(null,"Usuario Eliminado" );
		else JOptionPane.showMessageDialog(null,"ERROR" );		
	}
	
	public void refrescarTabla()
	{
		this.listaPersonas = (ArrayList<Personas>) pNeg.Obtener_lista_usuarios();
		this.ventanaListar.llenarTabla(listaPersonas);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {}
	
}
