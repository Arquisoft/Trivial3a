package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Morado implements Color {
	private String morado = "morado";

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas().devolverPregunta("otros");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((morado == null) ? 0 : morado.hashCode());
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
		Morado other = (Morado) obj;
		if (morado == null) {
			if (other.morado != null)
				return false;
		} else if (!morado.equals(other.morado))
			return false;
		return true;
	}
	@Override
	public String toString(){
		return morado;
	}

}
