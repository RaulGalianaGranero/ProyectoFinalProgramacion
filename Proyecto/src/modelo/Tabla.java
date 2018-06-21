package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tabla {
	private Connection conexion = Conexion.getConexion();
	private CocheDAOImp cocheDAOImp;
	private List<CocheDTO> listaDeCoches = new ArrayList<>();
	private String[] cabecera;
	private Object[][] datos;
	private int contador;

	
	public List<CocheDTO> getListaDeCoches() {
		return listaDeCoches;
	}


	public String[] getCabecera() {
		return cabecera;
	}


	public Object[][] getDatos() {
		return datos;
	}


	public Tabla(){
		cocheDAOImp = new CocheDAOImp();
		listaDeCoches = cocheDAOImp.listarCoches();
			contador = 0;
			datos = new Object[listaDeCoches.size()][5];
			
			
			for (CocheDTO coche : listaDeCoches) {
				
				datos[contador][0]= coche.getMatricula();
				datos[contador][0]= coche.getModelo();
				datos[contador][0]= coche.getMarca();
				datos[contador][0]= coche.getDireccion_empresa();
				datos[contador][0]= coche.getAnnio_modelo();

				contador++;
			}
			
			
			
		
	}
	
	

}