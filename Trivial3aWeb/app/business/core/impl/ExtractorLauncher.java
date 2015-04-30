package app.business.core.impl;

import app.business.core.Core;
import app.business.herramientas.extractor.impl.Extractor;

public class ExtractorLauncher implements Core {

	@Override
	public void run() {
		Extractor extractor = new Extractor();
		extractor.run();
	}

}
