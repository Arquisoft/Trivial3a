package business.game;

import business.game.login.ServiceLogin;
import business.game.tablero.ServiceTablero;
/**
 * Factoria encargada de la creacion de la Logica de Juego
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceGame {

	/**
	 * Crea instancia del Tablero [LOGICA]
	 * @return Tablero
	 */
	 ServiceTablero serviceTablero();
	 
	 /**
	  * Crea instancia del Login [LOGICA]
	  * @return Login
	  */
	 ServiceLogin serviceLogin();
}
