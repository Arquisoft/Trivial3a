package business.extractor.impl;

import business.extractor.ServiceExtractor;

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
