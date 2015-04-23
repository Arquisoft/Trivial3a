package business.game.tablero.nodos;

/**
 * Factoria de Nodos
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceFactoriaNodos {

	/**
	 * Creacion de un nodo de tipo Final
	 * @return
	 */
	Nodo getNodoFinal();
	
	/**
	 * Creacion de un nodo de tipo Normal
	 * @return
	 */
	Nodo getNodoNormal();
	
	/**
	 * Creacion de nodo de tipo "quesito"
	 * @return
	 */
	Nodo getNodoQuesito();
}
