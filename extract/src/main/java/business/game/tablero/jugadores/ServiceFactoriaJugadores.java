package business.game.tablero.jugadores;

import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.tableros.Tablero;
/**
 * Factoria de Jugadores
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceFactoriaJugadores {

	/**
	 * Metodo de creacion de Jugadores
	 * @param tam
	 * @param tablero tableroAsociado
	 * @return jugador
	 */
	Jugador getJugador(int tam, Tablero tablero);
}
