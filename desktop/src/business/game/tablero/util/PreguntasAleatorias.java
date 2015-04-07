package business.game.tablero.util;


public class PreguntasAleatorias {
	private static final PreguntasAleatorias INSTANCE = new PreguntasAleatorias();

	private PreguntasAleatorias() {
	}

	public static PreguntasAleatorias getInstance() {
		return INSTANCE;
	}

	public int dado() {
		return ((int) Math.random()) * 6;
	}
	
	
}
