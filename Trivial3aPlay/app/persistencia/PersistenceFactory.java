package persistencia;

import persistencia.impl.GetPreguntas;
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
	
	/**
	 * Crea una instancia de la clase de obtención de preguntas
	 */
	GetPreguntas getPreguntas();
	
}
