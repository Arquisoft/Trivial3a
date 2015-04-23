package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Amarillo implements Color {

	private String amarillo = "amarillo";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((amarillo == null) ? 0 : amarillo.hashCode());
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
		Amarillo other = (Amarillo) obj;
		if (amarillo == null) {
			if (other.amarillo != null)
				return false;
		} else if (!amarillo.equals(other.amarillo))
			return false;
		return true;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas()
				.devolverPregunta("historia");
	}

}
