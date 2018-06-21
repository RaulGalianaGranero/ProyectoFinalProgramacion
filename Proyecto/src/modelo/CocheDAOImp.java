package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CocheDAOImp implements CocheDAO{

	private Connection con = Conexion.getConexion();

	//METODO PARA AÑADIR UN COCHE A LA BD
	
	@Override
	public boolean annadirCoche(CocheDTO c) {

		String sql = "INSERT INTO coches (matricula,modelo,marca,direccion_empresa,annio_modelo) VALUES (?,?,?,?,?)";
		int rowsAffected=0;
		try (PreparedStatement preparedStatement=con.prepareStatement(sql);){

			preparedStatement.setString(1, c.getMatricula());
			preparedStatement.setString(2, c.getModelo());
			preparedStatement.setString(3, c.getMarca());
			preparedStatement.setString(4, c.getDireccion_empresa());
			preparedStatement.setString(5, c.getAnnio_modelo());
			rowsAffected = preparedStatement.executeUpdate();

		} catch (SQLException e1 ) {

			e1.printStackTrace();

		}
		return rowsAffected==1;
	}

	//METODO PARA ELIMINAR UN COCHE DE LA BD
	
	@Override
	public boolean eliminarCoche(String matricula) {

		int rowsAffected=0;

		String sql = "DELETE FROM coches WHERE matricula =? ";

		ResultSet resultset =null;

		try(PreparedStatement preparedstatement = con.prepareStatement(sql);) {

			preparedstatement.setString(1,matricula);
			rowsAffected = preparedstatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}		return rowsAffected==1;
	}

	//METODO PARA ACTUALIZAR UN COCHE

	@Override
	public boolean actualizarCoche(CocheDTO c) {
		int rowsaffected = 0;
		String sql = "UPDATE coche set modelo= ?, marca = ?, direccion_empresa= ?, annio_modelo=? where matricula = ?; ";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql);
) {
			preparedStatement.setString(1, c.getModelo());
			preparedStatement.setString(2, c.getMarca());
			preparedStatement.setString(3, c.getDireccion_empresa());
			preparedStatement.setString(4, c.getAnnio_modelo());
			preparedStatement.setString(5, c.getMatricula());

			
			rowsaffected = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsaffected == 1;
	}
	//METODO PARA CREAR LA TABLA COCHES EN LA BD

	public void crearBaseDeDatos () {

		String sql="CREATE TABLE IF NOT EXISTs coches (" + "matricula varchar(17) PRIMARY KEY, modelo varchar(25), marca varchar(25),"
				+ "direccion_empresa varchar(50), annio_modelo varchar(15) );";

		try (PreparedStatement ps=con.prepareStatement(sql);){

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//METODO PARA CARGAR LA LISTA DEL CSV EN NUESTRA TABLA COCHES

	public void annadirLista(List<CocheDTO> lista) {

		try {

			con.getAutoCommit();

			for(CocheDTO us : lista){

				annadirCoche(us);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<CocheDTO> listarCoches() {
		
		List<CocheDTO> listaCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches;";
		
		try (Statement statement = con.createStatement();){
			// Crear objeto ResultSet
			ResultSet resulset = statement.executeQuery(sql);
			while (resulset.next()) {
				CocheDTO coche = new CocheDTO(resulset.getString(1),
						resulset.getString(2), resulset.getString(3), resulset.getString(4),resulset.getString(5));
				listaCoches.add(coche);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaCoches;
	
	}

}
