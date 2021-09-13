package main;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.ActualizarPaseoDTO;
import entities.Paseo;

public class PaseoControllerCliente {

	public static final String MY_SERVER_URL="http://localhost:8080/paseos";

	public static final Client CLIENT = ClientBuilder.newClient();
	
	public static void obtenerListaPaseos() {
		WebTarget webTarget = CLIENT.target( MY_SERVER_URL );
		Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
		List<Paseo> paseos = invocation.get().readEntity( new GenericType<List<Paseo>>(){} );
		System.out.println("\n\n\nPaseos [Cliente]:\n");
		for( int i=0; i<paseos.size(); i++) {
			System.out.println( "\t " + (i+1) + ")" + paseos.get(i));
		}		
		System.out.println("\n\n");
	}
	
	public static void agregarPaseo(Paseo paseo) {
		WebTarget webTarget = CLIENT.target( MY_SERVER_URL );
		Builder invocation = webTarget.request( MediaType.APPLICATION_JSON );
		Response response = invocation.post( Entity.entity(paseo, MediaType.APPLICATION_JSON) );
		System.out.println( "Agregar Paseo: Respuesta servidor [" + response.getStatus() + "] " + response.getStatusInfo() + ": " + response.readEntity(String.class) );
		
	}
	
	public static void borrarPaseo(String idPaseo) {
		WebTarget webTarget = CLIENT.target( MY_SERVER_URL ).path(idPaseo);
		Builder invocation = webTarget.request( MediaType.APPLICATION_JSON );
		Response response = invocation.delete();
		System.out.println( "Borrar Paseo: Respuesta servidor [" + response.getStatus() + "] " + response.getStatusInfo() + ": " + response.readEntity(String.class) );	
	}
	
	public static void actualizarPaseo(String idPaseo, ActualizarPaseoDTO actualizado) {
		WebTarget webTarget = CLIENT.target( MY_SERVER_URL ).path(idPaseo);
		Builder invocation = webTarget.request( MediaType.APPLICATION_JSON );
		Response response = invocation.put( Entity.entity(actualizado, MediaType.APPLICATION_JSON) );
		System.out.println( "Borrar Paseo: Respuesta servidor [" + response.getStatus() + "] " + response.getStatusInfo() + ": " + response.readEntity(String.class) );	
	}
}
