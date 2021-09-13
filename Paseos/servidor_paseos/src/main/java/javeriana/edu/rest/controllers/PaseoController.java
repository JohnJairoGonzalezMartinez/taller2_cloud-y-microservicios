package javeriana.edu.rest.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javeriana.edu.rest.entities.ActualizarPaseoDTO;
import javeriana.edu.rest.entities.Paseo;

@Path("paseos")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class PaseoController {
	
	private static final String ARCHIVO_BD = "baseDatos.txt";
	private static List<Paseo> listaPaseos;
	
	public static void cargarPaseos() {
		listaPaseos = new ArrayList<>();
		try {
			List<Object> objects = FileController.leerArchivo(ARCHIVO_BD, Paseo.class);;
			for( Object itObject : objects ) {
				listaPaseos.add( (Paseo)itObject );
				System.out.println( "\t" + listaPaseos.get( listaPaseos.size() - 1 ) );
			}
			
		}
		catch (FileNotFoundException e) {
			System.out.println("Base de datos no encontrada");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	@GET
	public Response obtenerPaseos() {
		try {
			GenericEntity<List<Paseo>> entity = new GenericEntity<List<Paseo>>( listaPaseos ) {};
			return Response.status(200).entity( entity ).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500, "Error en el servidor: " + e.getMessage()).build();	
		}
		
	}
			
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response crearPaseo(Paseo nuevoPaseo) {
		try {
			if ( buscarPaseoPorId( nuevoPaseo.getId() ) != null ) {
				return Response.status(409, "Id duplicado").build();
			}
			listaPaseos.add( nuevoPaseo );
			FileController.escribirArchivo(ARCHIVO_BD, listaPaseos);
			return Response.status(200).entity(nuevoPaseo).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500, "Error en el servidor: " + e.getMessage()).build();
		}
	}
	
	@Path("{idPaseo}")
	@DELETE
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response borrarPaseo(@PathParam("idPaseo") String idPaseo) {
		try {
			Paseo buscado = buscarPaseoPorId( idPaseo ); 
			if ( buscado == null ) {
				return Response.status(404).build();
			}
			listaPaseos.remove(buscado);
			FileController.escribirArchivo(ARCHIVO_BD, listaPaseos);
			return Response.ok("Paseo eliminado").build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500, "Error en el servidor: " + e.getMessage()).build();
		}
	}
	
	@Path("{idPaseo}")
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response actualizarPaseo(ActualizarPaseoDTO actualizar, @PathParam("idPaseo") String idPaseo) {
		try {
			Paseo buscado = buscarPaseoPorId( idPaseo ); 
			if ( buscado == null ) {
				return Response.status(404).build();
			}
			if ( actualizar.getLugarLlegada() != null ) {
				buscado.setLugarLlegada( actualizar.getLugarLlegada() );
			}
			if ( actualizar.getLugarSalida() != null ) {
				buscado.setLugarSalida( actualizar.getLugarSalida() );
			}
			FileController.escribirArchivo(ARCHIVO_BD, listaPaseos);
			return Response.status(200).entity(buscado).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500, "Error en el servidor: " + e.getMessage()).build();
		}
	}

	private Paseo buscarPaseoPorId(String idBuscado) {
		for(Paseo itPaseo: listaPaseos) {
			if ( itPaseo.getId().equalsIgnoreCase(idBuscado) ) {
				return itPaseo;
			}
		}
		return null;
	}
	
}


