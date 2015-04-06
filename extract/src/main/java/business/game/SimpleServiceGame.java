package business.game;

import business.game.tablero.ServiceTablero;
import business.game.tablero.SimpleServiceTablero;

public class SimpleServiceGame implements ServiceGame {

	@Override
	public ServiceTablero serviceTablero() {
		return new SimpleServiceTablero();
	}

}
