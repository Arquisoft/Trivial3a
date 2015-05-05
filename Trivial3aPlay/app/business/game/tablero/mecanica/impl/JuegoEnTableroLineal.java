package business.game.tablero.mecanica.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import persistencia.impl.Estadisticas;

import modelo.preguntas.Pregunta;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.nodos.Nodo;
import business.game.tablero.tableros.Tablero;
import business.game.tablero.util.PreguntasAleatorias;

public class JuegoEnTableroLineal {

	private Queue<Jugador> jugadores = new ArrayDeque<Jugador>();
	public Jugador actual;
	private int valorDadoActual;
	private Pregunta pregunta;
	private ArrayList<String> respuestasMezcladas;
	private boolean gameFinished;

	// Ala aqu� poneis bots o lo que querais en principio un metodo jugar
	// hab�a
	// pensao pero eso ya os lo dejo a vosotros
	// con una cola para los jugadores, bots si queresis poner etc
	// hay q que controlar que al mover las fichas no se salga del array en el
	// que el tablero es una rueda
	// est�n hechos dos tableros uno rueda con radios y otro sin ellos
	// el ganar lo puse con un quesito de cada color creo que se entiende
	// bastante bien
	/**
	 * Retorna el texto de la pregunta actual
	 * 
	 * @return
	 */
	public String getTextoPregunta() {
		return pregunta.getPregunta();
	}

	public List<String> getRespuestasMezcladas() {
		return respuestasMezcladas;
	}
	
	public Jugador getActual() {
		return actual;
	}

	public void setActual(Jugador actual) {
		this.actual = actual;
	}

	public int getValorDado() {
		return valorDadoActual;
	}

	public Jugador getJugadorActual() {
		return actual;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}
	public Queue<Jugador> getQueueJugadores(){
		return jugadores;
	}

	private void jugarDerecha(int posiciones) {
		for (int i = posiciones; i > 0; i--) {
			if (actual.getActual().getSiguiente() != null) {
				actual.setActual(actual.getActual().getSiguiente());
				System.out.println("Moviendo Jugador" + i);
			} else {
				jugarIzquierda(i);
				break;
			}
		}
	}

	private void jugarIzquierda(int posiciones) {
		for (int i = posiciones; i > 0; i--) {
			if (actual.getActual().getAnterior() != null) {
				actual.setActual(actual.getActual().getAnterior());
				System.out.println("Moviendo Jugador" + i);
			} else {
				jugarDerecha(i);
				break;
			}
		}
	}

	/**
	 * metodo para lanzar el dado, cuando lo lanzas lo pones disabled
	 */
	public void lanzarDado() {
		valorDadoActual = PreguntasAleatorias.getInstance().dado();
	}

	/**
	 * el publico de mover a la derecha asociado al boton
	 */
	public void jugarDerecha() {
		jugarDerecha(valorDadoActual);
		pregunta = getPregunta();
		mostrarPregunta();
		respuestasMezcladas = PreguntasAleatorias.getInstance().desordenar(
				pregunta.getRespuestaCorrecta(),
				pregunta.getRespuestasIncorrectas());
	}

	private Pregunta getPregunta() {
		Tablero t = actual.getT();
		Nodo n = t.getReferencia();
		while((n = n.getSiguiente()) != null){
			System.out.println(n.toString());
			System.out.println(n.getColor());
		}
		System.out.println(actual.getActual().getColor().toString());

		return actual.getActual().getColor().getPregunta();
	}

	/**
	 * Para que hagas lo que quieras al ganar
	 */
	private void ganar() {
		gameFinished = true;
		Estadisticas.actualizar("numGanadas");
	}

	/**
	 * el publico de mover a la izquierda asociado al boton
	 */
	public void jugarIzquierda() {
		jugarIzquierda(valorDadoActual);
		pregunta = getPregunta();
		mostrarPregunta();
		respuestasMezcladas = PreguntasAleatorias.getInstance().desordenar(
				pregunta.getRespuestaCorrecta(),
				pregunta.getRespuestasIncorrectas());
	}

	/**
	 * otro m�todo para que muestres como quieras las pregnutas en la interfaz
	 * puedes usarlos o quitarlos o como veas
	 */
	private void mostrarPregunta() {
		// TODO Auto-generated method stub

	}

	/**
	 * cuando pulsas el boton que sea el primero el 0 etc
	 */
	public boolean responderAsociadoBoton(int boton) {
		Estadisticas.actualizar("preguntasJugadas");
		switch (boton) {
		case 0:
			if (respuestasMezcladas.get(0).equals(
					pregunta.getRespuestaCorrecta())) {
				actual.addQuesito(actual.getActual().getColor());
				if (actual.isVictoria())
					ganar();
				return true;
			} else {
				siguienteJugador();

			}
			break;
		case 1:
			if (respuestasMezcladas.get(1).equals(
					pregunta.getRespuestaCorrecta())) {
				actual.addQuesito(actual.getActual().getColor());
				if (actual.isVictoria())
					ganar();
				return true;
			} else {
				siguienteJugador();
			}
			break;
		case 2:
			if (respuestasMezcladas.get(2).equals(
					pregunta.getRespuestaCorrecta())) {
				actual.addQuesito(actual.getActual().getColor());
				if (actual.isVictoria())
					ganar();
				return true;
			} else {
				siguienteJugador();
			}
			break;
		case 3:
			if (respuestasMezcladas.get(3).equals(
					pregunta.getRespuestaCorrecta())) {
				actual.addQuesito(actual.getActual().getColor());
				if (actual.isVictoria())
					ganar();
				return true;
			} else {
				siguienteJugador();
			}
			break;
		}
		
		return false;
	}

	/**
	 * mueve la referencia del jugador al siguiente
	 */
	private void siguienteJugador() {
		jugadores.add(actual);
		actual = jugadores.poll();

	}

	/**
	 * Constructor
	 * 
	 * @param jugadores
	 */
	public JuegoEnTableroLineal(Queue<Jugador> jugadores) {
		super();
		this.jugadores = jugadores;
		actual = jugadores.poll();
	}
}
