package business.game.tablero.jugadores;

import business.game.tablero.logic.colores.Color;
import business.game.tablero.logic.nodos.Nodo;
import business.game.tablero.logic.nodos.NodoQuesito;
import business.game.tablero.logic.tableros.Tablero;

public class Jugador {
	private Color[] quesitos;
	private int tamActual = 0;
	private Tablero t;
	private Nodo actual;
	private boolean victoria = false;

	public Tablero getT() {
		return t;
	}

	public void setT(Tablero t) {
		this.t = t;
	}

	public Nodo getActual() {
		return actual;
	}

	public void setActual(Nodo actual) {
		this.actual = actual;
	}

	public boolean isVictoria() {
		return victoria;
	}

	public void setVictoria(boolean victoria) {
		this.victoria = victoria;
	}

	public Jugador(int tam, Tablero t) {
		quesitos = new Color[tam];
		this.t = t;
		actual = t.getReferencia();
	}

	public void moverDerecha(int posiciones) {
		for (int i = 0; i < posiciones; i++) {
			actual = actual.getSiguiente();
		}
	}

	public void moverIzquierda(int posiciones) {
		for (int i = 0; i < posiciones; i++) {
			actual = actual.getAnterior();
		}
	}

	public void moverArriba(int posiciones) {
		if (actual instanceof NodoQuesito
				&& ((NodoQuesito) actual).getArriba() != null)
			for (int i = 0; i < posiciones; i++) {
				actual = actual.getSiguiente();
			}
	}

	public void moverAbajo(int posiciones) {
		if (actual instanceof NodoQuesito
				&& ((NodoQuesito) actual).getArriba() != null)
			for (int i = 0; i < posiciones; i++) {
				actual = actual.getSiguiente();
			}
	}

	public void addQuesito(Color c) {
		for (int i = 0; i < tamActual; i++) {
			if (c.equals(quesitos[i])) {
				break;
			}
		}
		tamActual++;
		quesitos[tamActual] = c;
		victoria = comprobarQuesitos();
	}

	private boolean comprobarQuesitos() {
		for (int i = 0; i < quesitos.length; i++) {
			if(quesitos[i]==null){
				return false;
			}
		}
		return true;

	}

	public void removeQuesito(Color c) {
		for (int i = 0; i < tamActual; i++) {
			if (c.equals(quesitos[i])) {
				quesitos[i] = null;
				tamActual--;
				break;
			}
		}
	}

	public Color[] getQuesitos() {
		return quesitos;
	}

	public void setQuesitos(Color[] quesitos) {
		this.quesitos = quesitos;
	}

	public int getTamActual() {
		return tamActual;
	}

	public void setTamActual(int tamActual) {
		this.tamActual = tamActual;
	}
}
