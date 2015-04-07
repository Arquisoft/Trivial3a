package business.game.tablero.tableros;
/**
 * Factoria de distintos tipos de tablero
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceFactoriaTableros{

	/**
	 * Creacion de tablero circular
	 * @param tam
	 * @return
	 */
	Tablero getTableroCircular(int tam);
	
	/**
	 * Creacion de tablero lineal
	 * @param tam
	 * @return
	 */
	Tablero getTableroLineal(int tam);
	
	/**
	 * Creacion de tablero con forma de Rueda
	 * @param tam
	 * @return
	 */
	Tablero getTableroRueda(int tam);
	
	
}
