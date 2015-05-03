package business.game.tablero.nodos.impl;

import business.game.tablero.nodos.Nodo;
import business.game.tablero.nodos.ServiceFactoriaNodos;

public class FactoriaNodos implements ServiceFactoriaNodos{

	@Override
	public Nodo getNodoFinal() {
		return new NodoFinal(0,0);
	}

	@Override
	public Nodo getNodoNormal() {
		return new NodoNormal();
	}

	@Override
	public Nodo getNodoQuesito() {
		return new NodoQuesito();
	}

}
