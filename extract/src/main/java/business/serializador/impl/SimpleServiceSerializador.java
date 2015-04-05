package business.serializador.impl;

import business.serializador.ServiceSerializador;
import business.serializador.impl.json.JsonSerialImpl;

public class SimpleServiceSerializador implements ServiceSerializador{

	@Override
	public Serializador getSerializador() {
		return new JsonSerialImpl();
	}

	
}
