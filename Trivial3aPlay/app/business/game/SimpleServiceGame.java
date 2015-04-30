package business.game;

import business.game.login.ServiceLogin;
import business.game.login.SimpleServiceLogin;
import business.game.tablero.ServiceTablero;
import business.game.tablero.SimpleServiceTablero;
import business.game.tablero.mecanica.ServiceFactoriaMecanica;
import business.game.tablero.mecanica.impl.SimpleServiceFactoriaMecanica;

public class SimpleServiceGame implements ServiceGame {

	@Override
	public ServiceTablero serviceTablero() {
		return new SimpleServiceTablero();
	}

	@Override
	public ServiceLogin serviceLogin() {
		return new SimpleServiceLogin();
	}

	@Override
	public ServiceFactoriaMecanica serviceMecanica() {
		return new SimpleServiceFactoriaMecanica();
	}
}
