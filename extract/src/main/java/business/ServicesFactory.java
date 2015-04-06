package business;

import business.extractor.ServiceExtractor;
import business.parser.ServiceParser;
import business.preguntas.ServicePreguntas;
import business.serializador.ServiceSerializador;

/**
 * Factoría de la Logica
 * @author TeLoRompoTo
 *
 */
public interface ServicesFactory {

	/**
	 * Crea la el servicio de los extractores
	 * @return Clase extractor
	 */
	ServiceExtractor createServiceExtractor();
	
	/**
	 * Crea el servicio del parser
	 * @return Clase Parser
	 */
	ServiceParser createServiceParser();
	
	/**
	 * Crea el servicio de las preguntas
	 * @return Clase Pregunta
	 */
	ServicePreguntas createServicePreguntas();
	
	/**
	 * Crea el servicio del Serializador
	 * @return Clase Serializador
	 */
	ServiceSerializador createServiceSerializador();
	
}
