package business.game.tablero.mecanica;

import java.util.Queue;

import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;
/**
 * Clase Factoria de Mecánicas de Juego
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceFactoriaMecanica {

	/**
	 * Metodo que instancia las mecánicas de un juego en tablero lineal
	 * @param jugadores
	 * @return instanciaDeJuegoEnTableroLineal
	 */
	public JuegoEnTableroLineal getJuegoEnTableroLineal(Queue<Jugador> jugadores);
}
