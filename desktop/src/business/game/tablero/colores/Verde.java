package business.game.tablero.colores;

import business.game.tablero.util.ObtenerPreguntas;
import modelo.preguntas.Pregunta;

public class Verde implements Color {
	@Override
	public com.badlogic.gdx.graphics.Color getColorLibgdx() {
		return com.badlogic.gdx.graphics.Color.GREEN;
	}

	@Override
	public Pregunta getPregunta() {
		return (Pregunta) ObtenerPreguntas.devolverPregunta("ciencias");
	}

}
