package business.game.tablero.tableros;

import business.game.tablero.nodos.Nodo;

public interface Tablero {
	/**
	 * Retorna el nodo raiz (Casilla de inicio)
	 * @return 
	 */
	public Nodo getReferencia();
	public int getTamano();
}
