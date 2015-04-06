package business.game.tablero.logic.nodos;

import business.game.tablero.logic.colores.Color;
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

}
