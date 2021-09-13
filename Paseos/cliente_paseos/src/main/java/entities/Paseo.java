package entities;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Paseo {

	private String id;
	private String nombre;
	private String lugarSalida;
	private String lugarLlegada;
	private LocalDateTime fecha;
	
	public Paseo() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugarSalida() {
		return lugarSalida;
	}

	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}

	public String getLugarLlegada() {
		return lugarLlegada;
	}

	public void setLugarLlegada(String lugarLlegada) {
		this.lugarLlegada = lugarLlegada;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Paseo [id=" + id + ", nombre=" + nombre + ", lugarSalida=" + lugarSalida + ", lugarLlegada="
				+ lugarLlegada + ", fecha=" + fecha + "]";
	}
		
}
