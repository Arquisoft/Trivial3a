package business.game.tablero.jugadores.impl;

import modelo.usuario.Usuario;
import business.game.tablero.colores.Color;
import business.game.tablero.jugadores.ServiceFactoriaJugadores;
import business.game.tablero.tableros.Tablero;

public class FactoriaJugador implements ServiceFactoriaJugadores {

	@Override
	public Jugador getJugador(Tablero tablero, Usuario usuario, Color color) {
		return new Jugador(tablero, usuario, color);
	}

}
