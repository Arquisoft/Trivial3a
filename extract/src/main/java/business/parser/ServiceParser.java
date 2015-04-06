package business.parser;

import business.parser.impl.Parser;
/**
 * Factoria del Parser
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceParser {

	/**
	 * Devuelve ina instancia del Parser GIFT
	 * @param par ruta del archivo
	 * @return ParserGIFT
	 */
	Parser getParserGIFT(String par);
	
	/**
	 * Devuelve ina instancia del Parser QTI
	 * @param par ruta del archivo
	 * @return ParserQTI
	 */
	Parser getParserQTI(String par);
	
	/**
	 * Devuelve ina instancia del Parser XML
	 * @param par ruta del archivo
	 * @return ParserXML
	 */
	Parser getParserXML(String par);
}
