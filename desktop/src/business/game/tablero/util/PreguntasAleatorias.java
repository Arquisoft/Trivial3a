package business.game.tablero.util;

import java.util.ArrayList;
import java.util.Collections;

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

	public ArrayList<String> desordenar(String respuestaCorrecta,
			ArrayList<String> incorrectas) {
		incorrectas.add(respuestaCorrecta);
		Collections.shuffle(incorrectas);
		return incorrectas;

	}

}
