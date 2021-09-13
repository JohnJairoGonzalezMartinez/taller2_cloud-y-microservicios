package javeriana.edu.rest.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class FileController {

	private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
	
	public static void escribirArchivo(String nombreArchivo, List<?> data) throws Exception{
		FileWriter fw = new FileWriter( nombreArchivo );
		for(Object itObj : data) {
			fw.write( mapper.writeValueAsString(itObj) + '\n' );
		}
		fw.close();		
	}
	
	public static List<Object> leerArchivo(String nombreArchivo, Class<?> clase) throws FileNotFoundException, JsonMappingException, JsonProcessingException{
		Scanner myReader = new Scanner( new File(nombreArchivo) );
		List<Object> data = new ArrayList<>();
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			data.add( mapper.readValue(line, clase) );
		}
		myReader.close();
		return data;
	}
	
}
