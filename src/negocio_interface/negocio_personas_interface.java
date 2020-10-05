package negocio_interface;
import java.util.ArrayList;

import dao.DAO_Personas;
import entidad.Personas;

public interface negocio_personas_interface{
	
	public int AgrerarUsuario (Personas personas);
	public Personas Obtener_usuario (String dni);
	public ArrayList<Personas> Obtener_lista_usuarios();
	boolean EliminarPersona(String dni);
	

}
