package infraestructura;

import persistencia.PersistenceFactory;
import persistencia.impl.SimplePersistenceFactory;
import business.ServicesFactory;
import business.SimpleServiceFactory;
/**
 * Clase Factoria
 * @author Inigo Llaneza Aller
 *
 */
public class Factories {

	/**
	 * Factoria Business
	 */
	public static ServicesFactory services = new SimpleServiceFactory();
	/**
	 * Factoria Persitencia
	 */
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
}
