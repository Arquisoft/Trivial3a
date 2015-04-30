package business.game.tablero.nodos.impl;

import business.game.tablero.colores.Color;
import business.game.tablero.nodos.Nodo;
//nodo de pregunta que da quesito
public class NodoQuesito extends NodoNormal {
	private Nodo arriba;

	public Nodo getArriba() {
		return arriba;
	}

	@Override
	public String toString() {
		return "NodoQuesito []";
	}

	public void setArriba(Nodo arriba) {
		this.arriba = arriba;
	}

	public NodoQuesito(Color color) {
		super(color);
	}

	public NodoQuesito() {}
	
	public void setColor(Color color){
		super.setColor(color);;
	}

}
