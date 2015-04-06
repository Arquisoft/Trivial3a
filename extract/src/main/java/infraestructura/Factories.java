package infraestructura;

import persistencia.PersistenceFactory;
import persistencia.impl.SimplePersistenceFactory;
import business.ServicesFactory;
import business.SimpleServiceFactory;

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
