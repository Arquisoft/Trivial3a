package business.game.tablero.jugadores.impl;

import modelo.usuario.Usuario;
import business.game.tablero.colores.Color;
import business.game.tablero.nodos.Nodo;
import business.game.tablero.nodos.impl.NodoQuesito;
import business.game.tablero.tableros.Tablero;

public class Jugador {
	private Color[] quesitos;
	private int tamActual = 0;
	private Tablero t;
	private Nodo actual;
	private boolean victoria = false;
	private Usuario usuario;
	private Color color;/** El color escogido por el usuario */
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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

	public Jugador(Tablero t, Usuario usuario, Color color) {
		quesitos = new Color[t.getTamano()];
		this.t = t;
		actual = t.getReferencia();
		this.color = color;
		this.usuario = usuario;
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
