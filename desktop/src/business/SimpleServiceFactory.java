package business;

import business.extractor.ServiceExtractor;
import business.extractor.impl.SimpleServiceExtractor;
import business.parser.ServiceParser;
import business.parser.impl.SimpleServiceParser;
import business.preguntas.ServicePreguntas;
import business.preguntas.impl.SimpleServicePregunta;
import business.serializador.ServiceSerializador;
import business.serializador.impl.SimpleServiceSerializador;

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
	public ServicePreguntas createServicePreguntas() {
		return new SimpleServicePregunta();
	}

	@Override
	public ServiceSerializador createServiceSerializador() {
		return new SimpleServiceSerializador();
	}

}
