package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Azul implements Color {
	private String azul= "azul";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((azul == null) ? 0 : azul.hashCode());
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
		Azul other = (Azul) obj;
		if (azul == null) {
			if (other.azul != null)
				return false;
		} else if (!azul.equals(other.azul))
			return false;
		return true;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas().devolverPregunta(
				"geografia");
	}

}
