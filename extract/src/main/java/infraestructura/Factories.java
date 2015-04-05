package infraestructura;

import persistencia.PersistenceFactory;
import persistencia.impl.SimplePersistenceFactory;
import business.ServicesFactory;
import business.SimpleServiceFactory;

public class Factories {

	public static ServicesFactory serices = new SimpleServiceFactory();
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
}
