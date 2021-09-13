package entities;

import javax.xml.bind.annotation.XmlRootElement;

public @XmlRootElement
class ActualizarPaseoDTO {
	
	public String lugarSalida;
	public String lugarLlegada;
	
	public ActualizarPaseoDTO() {}

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

	@Override
	public String toString() {
		return "ActualizarPaseoDTO [lugarSalida=" + lugarSalida + ", lugarLlegada=" + lugarLlegada + "]";
	}	
	
	
}
