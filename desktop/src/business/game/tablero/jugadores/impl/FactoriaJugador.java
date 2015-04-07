package business.game.tablero.jugadores.impl;

import business.game.tablero.jugadores.ServiceFactoriaJugadores;
import business.game.tablero.tableros.Tablero;

public class FactoriaJugador implements ServiceFactoriaJugadores {

	@Override
	public Jugador getJugador(int tam, Tablero tablero) {
		return new Jugador(tam, tablero);
	}

}
