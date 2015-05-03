package business.game.tablero.nodos.impl;

import business.game.tablero.colores.Color;
import business.game.tablero.nodos.Nodo;
//nodo normal, el color hace referencia al tipo de pregunta
public class NodoNormal implements Nodo {
	private Nodo siguiente;
	private Nodo anterior;
	private Color color;
	private int cy;
	private int cx;

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

	public NodoNormal(Color color,int cx,int cy) {
		this.cx=cx;
		this.cx=cy;
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

	@Override
	public int getCX() {
		// TODO Auto-generated method stub
		return cx;
	}

	@Override
	public int getCY() {
		// TODO Auto-generated method stub
		return cy;
	}
}
