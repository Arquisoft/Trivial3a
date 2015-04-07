package business.game.tablero.colores;

import modelo.preguntas.Pregunta;

public class Incoloro implements Color{

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
