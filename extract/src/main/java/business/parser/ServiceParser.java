package business.parser;

import business.parser.impl.Parser;

public interface ServiceParser {

	Parser getParserGIFT(String par);
	Parser getParserQTI(String par);
	Parser getParserXML(String par);
}
