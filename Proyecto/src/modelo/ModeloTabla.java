package modelo;

import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

	String[] cabecera;
	Object[][] datos;
	String path="csv/coches.csv";
	CocheDAOImp cocheDAO = new CocheDAOImp();
	private List<CocheDTO> listaDeCoches;
	int contador = 0;






	public ModeloTabla() {
		cabecera = new String[]{"Matricula", "Modelo","Marca","Direccion_Empresa", "Año _Modelo"};
		try {
			listaDeCoches = CrearLista.crearLista(path);
			datos = new Object[listaDeCoches.size()][5];
			for (CocheDTO coche : listaDeCoches) {
				datos[contador][0]= coche.getMatricula();
				datos[contador][1]= coche.getModelo();
				datos[contador][2]= coche.getMarca();
				datos[contador][3]= coche.getDireccion_empresa();
				datos[contador][4]= coche.getAnnio_modelo();
				contador++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cabecera.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columIndex) {
		// TODO Auto-generated method stub
		return datos[rowIndex][columIndex];
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return cabecera[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex < 1)
			return false;
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		datos[rowIndex][columnIndex] = aValue;
		System.out.println(aValue);
		System.out.println(datos[rowIndex][columnIndex]);
		System.out.println(aValue);
		fireTableCellUpdated(rowIndex, columnIndex);
		String matricula = (String) datos[rowIndex][0];
		String modelo = (String) datos[rowIndex][1];
		String marca = (String) datos[rowIndex][2];
		String direccion_empresa = (String) datos[rowIndex][3];
		String annio_modelo = (String) datos[rowIndex][4];

		CocheDTO dtoUpdate = new CocheDTO(matricula, modelo, marca, direccion_empresa, annio_modelo);

		cocheDAO.actualizarCoche(dtoUpdate);
	}

	


}


