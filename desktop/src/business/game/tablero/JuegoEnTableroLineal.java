package business.game.tablero;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.util.PreguntasAleatorias;

public class JuegoEnTableroLineal {
	private boolean activo = true;
	private List<Jugador> contenedorDeJugadores = new ArrayList<Jugador>();
	private Queue<Jugador> jugadores = new ArrayDeque<Jugador>();
	private Jugador actual;
	private int valorDadoActual;

	// Ala aqu� poneis bots o lo que querais en principio un metodo jugar
	// hab�a
	// pensao pero eso ya os lo dejo a vosotros
	// con una cola para los jugadores, bots si queresis poner etc
	// hay q que controlar que al mover las fichas no se salga del array en el
	// que el tablero es una rueda
	// est�n hechos dos tableros uno rueda con radios y otro sin ellos
	// el ganar lo puse con un quesito de cada color creo que se entiende
	// bastante bien

	private void jugarDerecha(int posiciones) {
		for (int i = posiciones; i > 0; i++) {
			if (actual.getActual().getSiguiente() != null) {
				actual.setActual(actual.getActual().getSiguiente());
			} else {
				jugarIzquierda(i);
			}
		}
	}

	private void jugarIzquierda(int posiciones) {
		for (int i = posiciones; i > 0; i++) {
			if (actual.getActual().getAnterior() != null) {
				actual.setActual(actual.getActual().getAnterior());
			} else {
				jugarDerecha(i);
			}
		}
	}

	/**
	 * metodo para lanzar el dado, cuando lo lanzas lo pones disabled
	 */
	public void lanzarDado() {
		valorDadoActual = PreguntasAleatorias.getInstance().dado();
	}

	public void jugarDerecha() {
		jugarDerecha(valorDadoActual);
		boolean acierto = responderPregunta();
		if (acierto) {
			actual.addQuesito(actual.getActual().getColor());
			if (actual.isVictoria()) {
				ganar();
			}
		} else {
			jugadores.offer(actual);
			actual = jugadores.poll();
		}
	}

	/**
	 * Para que hagas lo que quieras al ganar
	 */
	private void ganar() {

	}

	public void jugarIzquierda() {
		jugarIzquierda(valorDadoActual);
		boolean acierto = responderPregunta();
		if (acierto) {
			actual.addQuesito(actual.getActual().getColor());
			if (actual.isVictoria()) {
				ganar();
			}
		} else {
			jugadores.offer(actual);
			actual = jugadores.poll();

		}
	}

	private boolean responderPregunta() {
		
		return false;
	}
}
