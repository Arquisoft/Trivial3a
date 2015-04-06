package business.game;

import business.game.login.ServiceLogin;
import business.game.tablero.ServiceTablero;

public interface ServiceGame {

	 ServiceTablero serviceTablero();
	 
	 ServiceLogin serviceLogin();
}
