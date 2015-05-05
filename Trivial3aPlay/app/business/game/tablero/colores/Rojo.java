package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Rojo implements Color{
	private String rojo = "rojo";
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rojo == null) ? 0 : rojo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rojo other = (Rojo) obj;
		if (rojo == null) {
			if (other.rojo != null)
				return false;
		} else if (!rojo.equals(other.rojo))
			return false;
		return true;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas().devolverPregunta("arte");
	}
	@Override
	public String toString(){
		return rojo;
	}

}
