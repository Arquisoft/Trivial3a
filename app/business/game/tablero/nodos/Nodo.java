package business.game.tablero.nodos;

import business.game.tablero.colores.Color;

public interface Nodo {
	 public Nodo getSiguiente();
	 public Nodo getAnterior();
	 public void setSiguiente(Nodo siguiente);
	 public void setAnterior(Nodo anterior);
	 public Color getColor();
	 

}
