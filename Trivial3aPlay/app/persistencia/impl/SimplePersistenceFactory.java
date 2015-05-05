package persistencia.impl;

import persistencia.PersistenceFactory;


public class SimplePersistenceFactory implements PersistenceFactory{

	@Override
	public Insert createInsert(String param) {
		return new Insert(param);
	}

	@Override
	public GetPreguntas getPreguntas() {
		return new GetPreguntas();
	}

}
