package business.game.tablero;

import business.game.tablero.jugadores.ServiceFactoriaJugadores;
import business.game.tablero.nodos.ServiceFactoriaNodos;
import business.game.tablero.tableros.ServiceFactoriaTableros;
/**
 * Factoria de la logica de tablero
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceTablero {

	/**
	 * Factoria de Tableros
	 * @return DistintosTableros
	 */
	ServiceFactoriaTableros getTablero();
	
	/**
	 * Factoria de Nodos
	 * @return DistintosNodos
	 */
	ServiceFactoriaNodos getNodos();
	
	/**
	 * Factoria de Jugador
	 * @return Jugador
	 */
	ServiceFactoriaJugadores getJugador();
}
