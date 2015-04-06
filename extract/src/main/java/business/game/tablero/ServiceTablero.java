package business.game.tablero;

import business.game.tablero.jugadores.ServiceFactoriaJugadores;
import business.game.tablero.nodos.ServiceFactoriaNodos;
import business.game.tablero.tableros.ServiceFactoriaTableros;

public interface ServiceTablero {

	ServiceFactoriaTableros getTablero();
	
	ServiceFactoriaNodos getNodos();
	
	ServiceFactoriaJugadores getJugador();
}
