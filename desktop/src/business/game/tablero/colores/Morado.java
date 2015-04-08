package business.game.tablero.colores;

import business.game.tablero.util.ObtenerPreguntas;
import modelo.preguntas.Pregunta;

public class Morado implements Color {

	@Override
	public com.badlogic.gdx.graphics.Color getColorLibgdx() {
		return com.badlogic.gdx.graphics.Color.PURPLE;
	}

	@Override
	public Pregunta getPregunta() {
		return (Pregunta) ObtenerPreguntas.devolverPregunta("otros");
	}

}
