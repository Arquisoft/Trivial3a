package business;

import modelo.ServiceModelo;
import modelo.SimpleServiceModelo;
import business.herramientas.extractor.ServiceExtractor;
import business.herramientas.extractor.impl.SimpleServiceExtractor;
import business.herramientas.parser.ServiceParser;
import business.herramientas.parser.impl.SimpleServiceParser;
import business.herramientas.serializador.ServiceSerializador;
import business.herramientas.serializador.impl.SimpleServiceSerializador;

public class SimpleServiceFactory implements ServicesFactory {

	@Override
	public ServiceExtractor createServiceExtractor() {
		return new SimpleServiceExtractor();
	}

	@Override
	public ServiceParser createServiceParser() {
		return new SimpleServiceParser();
	}

	@Override
	public ServiceModelo createServicePreguntas() {
		return new SimpleServiceModelo();
	}

	@Override
	public ServiceSerializador createServiceSerializador() {
		return new SimpleServiceSerializador();
	}

}
