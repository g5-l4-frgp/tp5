package negocio;
import java.util.ArrayList;
import java.util.List;
import dao.DAO_Personas;
import entidad.Personas;
import negocio_interface.negocio_personas_interface;

public class negocio_personas implements negocio_personas_interface{
	
	private DAO_Personas dao_p = new DAO_Personas();

	@Override
	public int AgrerarUsuario(Personas personas) {
		// TODO Auto-generated method stub
		return dao_p.AgrerarUsuario(personas);
	}

	@Override
	public Personas Obtener_usuario(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Personas> Obtener_lista_usuarios() {
		// TODO Auto-generated method stub
		return dao_p.Obtener_lista_usuarios();
	}
	
}
		

	
	

