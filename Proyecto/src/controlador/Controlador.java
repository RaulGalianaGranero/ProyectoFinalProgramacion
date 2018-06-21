package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.CocheDAOImp;
import modelo.CocheDTO;
import modelo.CrearLista;
import modelo.ModeloTabla;
import modelo.Tabla;
import vista.Interfaz;



public class Controlador implements ActionListener {
	
	private Interfaz vista;
	private CocheDAOImp cocheDAO;
	private List<CocheDTO> listaCoches;
	private String path="csv/coches.csv";
	private JTable tablaVista;
	private ModeloTabla modeloTabla;
	CocheDAOImp implementacion = new CocheDAOImp();
	
	

	public Controlador(Interfaz vista) {
		this.vista = vista;
		cocheDAO = new CocheDAOImp();
	
		registrarBotones();
		crearListaYBaseDeDatos();
		rellenarTabla();
		activarBotones();
		
		
		
		
	}
	private void crearListaYBaseDeDatos() {
		
		try {
			listaCoches=CrearLista.crearLista(path);
			cocheDAO.crearBaseDeDatos();
			cocheDAO.annadirLista(listaCoches);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void registrarBotones() {
		vista.getBotonActualizar().addActionListener(this);
		vista.getBotonInsertar().addActionListener(this);
		vista.getBotonLimpiar().addActionListener(this);
		vista.getBotonMas20().addActionListener(this);
		vista.getBotonMenos20().addActionListener(this);
		vista.getMenuAyuda().addActionListener(this);
		vista.getMenuItemSalir().addActionListener(this);
	}
	
	

	private void activarBotones() {
		
		vista.getBotonInsertar().setEnabled(true);
		vista.getBotonActualizar().setEnabled(true);
		vista.getBotonLimpiar().setEnabled(true);
		vista.getBotonMas20().setEnabled(true);
		vista.getBotonMenos20().setEnabled(true);
	}



	private void rellenarTabla() {
		modeloTabla = new ModeloTabla();
		tablaVista = new JTable(modeloTabla);
		vista.getScrollPane().setViewportView(tablaVista);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JMenuItem.class) {
			JMenuItem jmenuitem = (JMenuItem) e.getSource();
			if (jmenuitem.getText().equals("Salir")) {
				salir();
			}
			
		}
		if (e.getSource().getClass() == JButton.class) {
			JButton jButton = (JButton) e.getSource();
			String textoBoton = jButton.getText();
			switch (textoBoton) {
			case "Borrar":
				/*int row = tablaVista.getSelectionModel().getMinSelectionIndex();
				((ModeloTabla)tablaVista.getModel()).deleteRow(row);*/
				break;
			case "Insertar":
				
				String matricula =vista.getTextFieldMatricula().getText();
				String modelo =vista.getTextFieldModelo().getText();
				String marca =vista.getTextFieldMarca().getText();
				String direccion_empresa =vista.getTextFieldDireccion_empresa().getText();
				String anio_modelo =vista.getTextFieldAnnio_modelo().getText();
				
				CocheDTO c = new CocheDTO(matricula, modelo, marca, direccion_empresa, anio_modelo);
				implementacion.annadirCoche(c);
				
				vista.getTextFieldMatricula().setText("");
				vista.getTextFieldModelo().setText("");
				vista.getTextFieldMarca().setText("");
				vista.getTextFieldDireccion_empresa().setText("");
				vista.getTextFieldAnnio_modelo().setText("");
		

			
			}
		}
		
	}

	private void InsertarCoche() {

		
	}


	private void informacion(String string) {
		// TODO Auto-generated method stub
		
	}
	
	private void actualizarTabla() {
		
		
	}

	private void salir() {
		System.exit(0);
		
	}

}
