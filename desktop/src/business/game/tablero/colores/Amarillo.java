package business.game.tablero.colores;

import infraestructura.Factories;
import modelo.preguntas.Pregunta;

public class Amarillo implements Color{

	@Override
	public com.badlogic.gdx.graphics.Color getColorLibgdx() {
		return com.badlogic.gdx.graphics.Color.YELLOW;
	}

	@Override
	public Pregunta getPregunta() {
		return Factories.persistence.getPreguntas().devolverPregunta("historia");
	}

}
