package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Interfaz {

	private JFrame frame;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldAnnio_modelo;
	private JTextField textFieldDireccion_empresa;
	private JTextField textFieldMatricula;
	private JLabel labelMatricula;
	private JLabel labelModelo;
	private JLabel labelMarca;
	private JLabel labelDireccion_empresa;
	private JLabel labelAnnio_modelo;
	private JButton botonInsertar;
	private JButton botonLimpiar;
	private JButton botonMenos20;
	private JButton botonActualizar;
	private JButton botonMas20;
	private JMenuItem menuItemAnnadirFichero;
	private JMenu menuAyuda;
	private JMenuItem menuItemSalir;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazProyecto window = new InterfazProyecto();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnDatos = new JMenu("Datos");
		menuBar.add(mnDatos);
		
		menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		menuItemSalir = new JMenuItem("Salir");
		menuAyuda.add(menuItemSalir);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelTabla = new JPanel();
		tabbedPane.addTab("Datos", null, panelTabla, null);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panelTabla.add(panel_1, BorderLayout.SOUTH);
		
		botonMenos20 = new JButton("<");
		botonMenos20.setEnabled(false);
		panel_1.add(botonMenos20);
		
		botonActualizar = new JButton("Actualizar");
		botonActualizar.setEnabled(false);
		panel_1.add(botonActualizar);
		
		botonMas20 = new JButton(">");
		botonMas20.setEnabled(false);
		panel_1.add(botonMas20);
		
		scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelInsertar = new JPanel();
		tabbedPane.addTab("Insertar", null, panelInsertar, null);
		panelInsertar.setLayout(new GridLayout(0, 2, 0, 40));
		
		labelMatricula = new JLabel("Matricula:");
		panelInsertar.add(labelMatricula);
		
		textFieldMatricula = new JTextField();
		panelInsertar.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		labelModelo = new JLabel("Modelo:");
		panelInsertar.add(labelModelo);
		
		textFieldModelo = new JTextField();
		panelInsertar.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		labelMarca = new JLabel("Marca:");
		panelInsertar.add(labelMarca);
		
		textFieldMarca = new JTextField();
		panelInsertar.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		labelDireccion_empresa = new JLabel("Direccion Empresa");
		panelInsertar.add(labelDireccion_empresa);
		
		textFieldDireccion_empresa = new JTextField();
		panelInsertar.add(textFieldDireccion_empresa);
		textFieldDireccion_empresa.setColumns(10);
		
		labelAnnio_modelo = new JLabel("Año Modelo:");
		panelInsertar.add(labelAnnio_modelo);
		
		textFieldAnnio_modelo = new JTextField();
		panelInsertar.add(textFieldAnnio_modelo);
		textFieldAnnio_modelo.setColumns(10);
		
		JPanel panel = new JPanel();
		panelInsertar.add(panel);
		
		botonInsertar = new JButton("Insertar");
		botonInsertar.setEnabled(false);
		panel.add(botonInsertar);
		
		botonLimpiar = new JButton("Borrar");
		botonLimpiar.setEnabled(false);
		panel.add(botonLimpiar);
	}

	public JMenuItem getMenuItemSalir() {
		return menuItemSalir;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBotonLimpiar() {
		return botonActualizar;
	}

	public JButton getBotonInsertar() {
		return botonInsertar;
	}

	public JButton getBotonActualizar() {
		return botonLimpiar;
	}

	public JButton getBotonMenos20() {
		return botonMenos20;
	}

	public JButton getBotonMas20() {
		return botonMas20;
	}

	public JMenu getMenuAyuda() {
		return menuAyuda;
	}

	public JMenuItem getMenuItemAnnadirFichero() {
		return menuItemAnnadirFichero;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public JTextField getTextFieldAnnio_modelo() {
		return textFieldAnnio_modelo;
	}

	public JTextField getTextFieldDireccion_empresa() {
		return textFieldDireccion_empresa;
	}

	public JTextField getTextFieldMatricula() {
		return textFieldMatricula;
	}

	public JLabel getLabelMatricula() {
		return labelMatricula;
	}

	public JLabel getLabelModelo() {
		return labelModelo;
	}

	public JLabel getLabelMarca() {
		return labelMarca;
	}

	public JLabel getLabelDireccion_empresa() {
		return labelDireccion_empresa;
	}

	public JLabel getLabelAnnio_modelo() {
		return labelAnnio_modelo;
	}
	
	

}
