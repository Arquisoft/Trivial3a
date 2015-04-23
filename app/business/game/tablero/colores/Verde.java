package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Verde implements Color {
	private String verde = "verde";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verde == null) ? 0 : verde.hashCode());
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
		Verde other = (Verde) obj;
		if (verde == null) {
			if (other.verde != null)
				return false;
		} else if (!verde.equals(other.verde))
			return false;
		return true;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas()
				.devolverPregunta("ciencias");
	}

}
