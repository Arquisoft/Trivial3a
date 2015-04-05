package business;

import business.extractor.ServiceExtractor;
import business.parser.ServiceParser;
import business.preguntas.ServicePreguntas;
import business.serializador.ServiceSerializador;

public interface ServicesFactory {

	ServiceExtractor createServiceExtractor();
	ServiceParser createServiceParser();
	ServicePreguntas createServicePreguntas();
	ServiceSerializador createServiceSerializador();
	
}
