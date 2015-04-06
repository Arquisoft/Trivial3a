package infraestructura;

import persistencia.PersistenceFactory;
import persistencia.impl.SimplePersistenceFactory;
import presentacion.PresentationFactory;
import presentacion.SimplePresentationFactory;
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
	
	public static PresentationFactory presentation = new SimplePresentationFactory();
}
