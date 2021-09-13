package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.ActualizarPaseoDTO;
import entities.Paseo;

public class RestClientMain {

	private static Scanner sc = new Scanner( System.in );
	
	private static String leerString(String mensaje) {
		System.out.print(mensaje);
		return sc.nextLine();
	}
	
	public static void agregarPaseo() {
		PaseoControllerCliente.agregarPaseo( new Paseo() {{
			setId( leerString("Id: ") );
			setNombre( leerString("Nombre: ") );
			setLugarSalida( leerString("Lugar de Salida: ") );
			setLugarLlegada( leerString("Lugar Llegada: ") );
			setFecha( LocalDateTime.of( LocalDate.parse(leerString("Fecha (dd/mm/aaaa): "), DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.of(0, 0) ) ) ;
			System.out.println("\n\n");
		}});
	}
	
	public static void obtenerPaseos() {
		PaseoControllerCliente.obtenerListaPaseos();
	}
	
	public static void actualizarPaseo() {
		String idPaseo = leerString("Id paseo: ");
		PaseoControllerCliente.actualizarPaseo( idPaseo, new ActualizarPaseoDTO() {{
			setLugarSalida( leerString("Lugar de Salida: ") );
			setLugarLlegada( leerString("Lugar Llegada: ") );
		}});
	}
	
	public static void eliminarPaseo() {
		String idPaseo = leerString("Id paseo: ");
		PaseoControllerCliente.borrarPaseo(idPaseo);
	}
	
	public static void main(String args[]){
		int opcion = 1;
		String line = "-".repeat(50) + "\n"; 
		
		while(opcion != 0) {
			System.out.println( line + "\tCLIENTE JERSEY PASEOS\n" + line);
			System.out.println( "\t1). Obtener Lista Paseos");
			System.out.println( "\t2). Crear Paseo");
			System.out.println( "\t3). Actualizar Paseo");
			System.out.println( "\t4). Eliminar Paseo");
			System.out.println( "\t0). Salir\n");
			System.out.print("Seleccione una opcion: ");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
				case 1: obtenerPaseos(); break;
				case 2: agregarPaseo(); break;
				case 3: actualizarPaseo(); break;
				case 4: eliminarPaseo(); break;
				case 0: System.out.println("Adios!!!");; break;
				default: System.out.println("opcion Invalida"); break;
			}
			System.out.println("\n".repeat(5));
		}
		sc.close();
	}
}