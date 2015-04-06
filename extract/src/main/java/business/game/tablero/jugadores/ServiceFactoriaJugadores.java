package business.game.tablero.jugadores;

import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.tableros.Tablero;

public interface ServiceFactoriaJugadores {

	Jugador getJugador(int tam, Tablero tablero);
}
