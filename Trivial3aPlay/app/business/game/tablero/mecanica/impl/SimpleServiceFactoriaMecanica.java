package business.game.tablero.mecanica.impl;

import java.util.Queue;

import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.mecanica.ServiceFactoriaMecanica;

public class SimpleServiceFactoriaMecanica implements ServiceFactoriaMecanica {

	@Override
	public JuegoEnTableroLineal getJuegoEnTableroLineal( Queue<Jugador> jugadores) {
		return new JuegoEnTableroLineal(jugadores);
	}

}
