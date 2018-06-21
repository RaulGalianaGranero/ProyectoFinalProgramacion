package modelo;

import java.util.List;

public interface CocheDAO {

	boolean annadirCoche(CocheDTO c);
	boolean eliminarCoche(String matricula);
	boolean actualizarCoche (CocheDTO c);
	public void crearBaseDeDatos ();
	public void annadirLista(List<CocheDTO> lista);
	public List<CocheDTO> listarCoches();
}
