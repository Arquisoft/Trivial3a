package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Verde implements Color {
	@Override
	public com.badlogic.gdx.graphics.Color getColorLibgdx() {
		return com.badlogic.gdx.graphics.Color.GREEN;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas().devolverPregunta("ciencias");
	}

}
