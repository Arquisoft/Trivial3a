package business.game;

import business.game.login.ServiceLogin;
import business.game.tablero.ServiceTablero;
import business.game.tablero.mecanica.ServiceFactoriaMecanica;
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
	 
	 /**
	  * Crea una instancia de las mecánicas [LOGICA]
	  * @return
	  */
	 ServiceFactoriaMecanica serviceMecanica();
}
