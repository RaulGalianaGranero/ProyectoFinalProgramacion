package modelo;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;

public class CrearLista {


public static List<CocheDTO> crearLista (String pathCsv) throws FileNotFoundException{
	
	List<CocheDTO> listaCoches = new ArrayList<CocheDTO>();
	
	try {

		

		CsvReader coches_import = new CsvReader(pathCsv);
		coches_import.readHeaders();
		

		while (coches_import.readRecord())
		{
			String matricula = coches_import.get("matricula");
			String modelo = coches_import.get("modelo");
			String marca = coches_import.get("marca");
			String direccion_empresa = coches_import.get("direccion_empresa");
			String anio_modelo = coches_import.get("anio_modelo");


			listaCoches.add(new CocheDTO(matricula, modelo, marca, direccion_empresa, anio_modelo));    
		}

		coches_import.close();

		for(CocheDTO us : listaCoches){

			System.out.println(us.getMatricula() +" " + us.getModelo()+ " " 
					+ us.getMarca() + " " + us.getDireccion_empresa() +" "+ us.getAnnio_modelo());
		}

	}
	
	catch (FileNotFoundException e) {
        e.printStackTrace();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
	
	return listaCoches ;
	
} 	
	
	
}



