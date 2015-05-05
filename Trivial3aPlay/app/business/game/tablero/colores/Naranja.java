package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Naranja implements Color {
	private String naranja = "naranja";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naranja == null) ? 0 : naranja.hashCode());
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
		Naranja other = (Naranja) obj;
		if (naranja == null) {
			if (other.naranja != null)
				return false;
		} else if (!naranja.equals(other.naranja))
			return false;
		return true;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas()
				.devolverPregunta("deportes");
	}
	@Override
	public String toString(){
		return naranja;
	}

}
