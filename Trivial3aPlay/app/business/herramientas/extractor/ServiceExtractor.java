package business.herramientas.extractor;

import business.herramientas.extractor.impl.Extractor;
import business.herramientas.extractor.impl.MenuExtractor;
/**
 * Factoria de Extractores 
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceExtractor {

	/**
	 * Devuelve una instancia del extractor
	 * @return
	 */
	Extractor getExtractor();
	
	/**
	 * Devuelve una instancia del menu del extractor
	 * @return
	 */
	MenuExtractor getMenuExtractor();
	
}
