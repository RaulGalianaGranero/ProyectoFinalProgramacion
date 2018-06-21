package main;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.CocheDAOImp;
import modelo.CocheDTO;
import modelo.Conexion;
import modelo.CrearLista;
import vista.Interfaz;
import controlador.Controlador;

public class main {

	
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Interfaz ventana = new Interfaz();
						new Controlador(ventana);
						/*CocheDTO e = new CocheDTO("a", "aaa", "aaaaa", "dsdgsdgsdg", "sdgsdgsdgsd");
						CocheDAOImp imp= new CocheDAOImp();
						imp.crearBaseDeDatos();
						imp.annadirCoche(e);*/
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
			
	
		
	}


