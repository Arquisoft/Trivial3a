package business.game.tablero;

import business.game.tablero.jugadores.ServiceFactoriaJugadores;
import business.game.tablero.jugadores.impl.FactoriaJugador;
import business.game.tablero.nodos.ServiceFactoriaNodos;
import business.game.tablero.nodos.impl.FactoriaNodos;
import business.game.tablero.tableros.ServiceFactoriaTableros;
import business.game.tablero.tableros.impl.FactoriaTableros;

public class SimpleServiceTablero implements ServiceTablero {

	@Override
	public ServiceFactoriaTableros getTablero() {
		return new FactoriaTableros();
	}

	@Override
	public ServiceFactoriaNodos getNodos() {
		return new FactoriaNodos();
	}

	@Override
	public ServiceFactoriaJugadores getJugador() {
		return new FactoriaJugador();
	}

}
