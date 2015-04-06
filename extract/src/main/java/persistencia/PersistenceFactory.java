package persistencia;

import persistencia.impl.Insert;

/**
 * Interfaz: Factoria de la base de datos
 * @author Inigo Llaneza Aller
 *
 */
public interface PersistenceFactory {
	
	/**
	 * Crea una instancia del metodo insertar
	 * @param param 
	 * @return instancia Insert
	 */
	Insert createInsert(String param);
}
