package business.game.tablero.logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import business.game.tablero.jugadores.Jugador;

public class Juego {
	private boolean activo = true;
	private List<Jugador> contenedorDeJugadores = new ArrayList<Jugador>();
	private Queue<Jugador> jugadores = new ArrayDeque<Jugador>();

	
	//Ala aqu� poneis bots o lo que querais en principio un metodo jugar hab�a pensao pero eso ya os lo dejo a vosotros
	//con una cola para los jugadores, bots si queresis poner etc
	//hay q que controlar que al mover las fichas no se salga del array en el que el tablero es una rueda
	//est�n hechos dos tableros uno rueda con radios y otro sin ellos
	//el ganar lo puse con un quesito de cada color creo que se entiende bastante bien
}
