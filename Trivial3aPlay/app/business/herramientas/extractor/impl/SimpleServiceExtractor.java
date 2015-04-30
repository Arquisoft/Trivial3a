package business.herramientas.extractor.impl;

import business.herramientas.extractor.ServiceExtractor;

public class SimpleServiceExtractor implements ServiceExtractor {

	@Override
	public Extractor getExtractor() {
		return new Extractor();
	}

	@Override
	public MenuExtractor getMenuExtractor() {
		return new MenuExtractor();
	}

}
