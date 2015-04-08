package business;

import modelo.ServiceModelo;
import business.game.ServiceGame;
import business.herramientas.extractor.ServiceExtractor;
import business.herramientas.parser.ServiceParser;
import business.herramientas.serializador.ServiceSerializador;
/**
 * Factoria de la capa Business
 * @author Inigo Llaneza Aller
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
	ServiceModelo createServicePreguntas();
	
	/**
	 * Crea el servicio del Serializador
	 * @return Clase Serializador
	 */
	ServiceSerializador createServiceSerializador();
	
	/**
	 * Crea el servicio del Game
	 * @return Clase de Game
	 */
	ServiceGame createServiceGame();
	
}
