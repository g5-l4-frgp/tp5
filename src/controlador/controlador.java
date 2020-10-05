package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import presentacion_vista.Agregar;
import presentacion_vista.Listar;
import presentacion_vista.Modificar;
import presentacion_vista.Ventana_principal;
import negocio.negocio_personas;
import entidad.Personas;
public class controlador implements ActionListener {

	private Ventana_principal Ventana_principal;
	private Modificar VentanaModificar;
	private Agregar ventanaAgregar;
	private Listar ventanaListar;
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
			this.ventanaAgregar.mostrarMensaje(mensaje);
		}
		else
			mensaje="Persona no agregada, complete todos los campos";
		
		this.ventanaAgregar.mostrarMensaje(mensaje);
		
	
	}
	
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

	@Override
	public void actionPerformed(ActionEvent arg0) {}
	
}
