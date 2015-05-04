package business.game.tablero.nodos.impl;

import business.game.tablero.colores.Color;
import business.game.tablero.nodos.Nodo;

//nodo �ltimo que posee las 6-7-n entradas 
public class NodoFinal implements Nodo {
	private Nodo[] n;
	private int x;
	private int y;

	
	public NodoFinal(){};
	
	public NodoFinal(int tam) {
		n = new Nodo[tam];
	}

	public NodoFinal(Nodo[] n) {
		super();
		this.n = n;
	}

	@Override
	public Nodo getSiguiente() {
		// TODO Auto-generated method stub
		return null;
	}

	public Nodo[] getN() {
		return n;
	}

	public void setN(Nodo[] n) {
		this.n = n;
	}

	@Override
	public Nodo getAnterior() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSiguiente(Nodo siguiente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnterior(Nodo anterior) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

}
