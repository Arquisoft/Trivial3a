package business.game.tablero.nodos.impl;

import business.game.tablero.colores.Color;
import business.game.tablero.nodos.Nodo;
//nodo normal, el color hace referencia al tipo de pregunta
public class NodoNormal implements Nodo {
	private Nodo siguiente;
	private Nodo anterior;
	private Color color;

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public NodoNormal(Color color) {
		super();
		this.color = color;
	}

	public NodoNormal() {
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
