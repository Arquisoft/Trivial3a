package business.herramientas.parser.impl;

import business.herramientas.parser.ServiceParser;


public class SimpleServiceParser implements ServiceParser{

	@Override
	public Parser getParserGIFT(String par) {
		return new ParserGIFT(par);
	}

	@Override
	public Parser getParserQTI(String par) {
		return new ParserQTI(par);
	}

	@Override
	public Parser getParserXML(String par) {
		return new ParserXML(par);
	}

	
	
}
