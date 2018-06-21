package modelo;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

//Clase para crear una conexion a una base de datos 

public class Conexion {

	private static Connection con = null;

	private Conexion() {}

	public static Connection getConexion() {

		if(con==null) {

			Properties properties = new Properties();

			try {
				properties.load(new FileReader("bd/bd.properties"));
				String DRIVER = properties.getProperty("DRIVER");
				String DB_URL = properties.getProperty("DB_URL");
				String BD = properties.getProperty("BD");

				// cargar el driver con Clas.forName

				Class.forName(DRIVER);

				// Configuramos el objeto Config para permitir foreign keys

				SQLiteConfig sqLiteConfig = new SQLiteConfig();
				sqLiteConfig.enforceForeignKeys(true);
				// Inicializamos el objeto conexion con DriverManager.getConnection

				con = DriverManager.getConnection(
						DB_URL + BD, sqLiteConfig.toProperties());
			} catch (IOException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		return con;
	}
//Metodo para desconectarse de la base de datos
	
	public static void desconectar(){

		if (con != null)

			try {

				con.close();

			} 
		catch (SQLException e) {

			e.printStackTrace();

		}
	}
}
