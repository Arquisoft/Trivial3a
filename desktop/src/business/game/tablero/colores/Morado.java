package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Morado implements Color {

	@Override
	public com.badlogic.gdx.graphics.Color getColorLibgdx() {
		return com.badlogic.gdx.graphics.Color.PURPLE;
	}

	@Override
	public Pregunta getPregunta() {
		return (Pregunta) Factories.persistence.getPreguntas().devolverPregunta("otros");
	}

}
