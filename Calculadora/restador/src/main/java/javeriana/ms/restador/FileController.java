package javeriana.ms.restador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {

	public static void escribirArchivo(String nombreArchivo, String data) throws Exception{
		FileWriter fw = new FileWriter( nombreArchivo, true );
		fw.append( data + '\n' );
		fw.close();		
	}
	
	public static List<String> leerArchivo(String nombreArchivo) throws FileNotFoundException{
		Scanner myReader = new Scanner( new File(nombreArchivo) );
		List<String> data = new ArrayList<>();
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			data.add( line );
		}
		myReader.close();
		return data;
	}
	
}
