package persistencia;

import persistencia.impl.Insert;


public interface PersistenceFactory {
	Insert createInsert(String param);
}
