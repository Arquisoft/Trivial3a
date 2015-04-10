package business.game.tablero.colores;

import modelo.preguntas.Pregunta;

public class Incoloro implements Color {
	private String incoloro = "incoloro";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((incoloro == null) ? 0 : incoloro.hashCode());
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
		Incoloro other = (Incoloro) obj;
		if (incoloro == null) {
			if (other.incoloro != null)
				return false;
		} else if (!incoloro.equals(other.incoloro))
			return false;
		return true;
	}

	@Override
	public com.badlogic.gdx.graphics.Color getColorLibgdx() {
		return com.badlogic.gdx.graphics.Color.WHITE;
	}

	@Override
	public Pregunta getPregunta() {
		// TODO Auto-generated method stub
		return null;
	}

}
