package business.herramientas.serializador.impl;

import business.herramientas.serializador.Serializador;
import business.herramientas.serializador.ServiceSerializador;
import business.herramientas.serializador.impl.json.JsonSerialImpl;

public class SimpleServiceSerializador implements ServiceSerializador{

	@Override
	public Serializador getSerializador() {
		return new JsonSerialImpl();
	}

	
}
