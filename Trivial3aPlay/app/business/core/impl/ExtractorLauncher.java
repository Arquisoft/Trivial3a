package business.core.impl;

import business.core.Core;
import business.herramientas.extractor.impl.Extractor;

public class ExtractorLauncher implements Core {

	@Override
	public void run() {
		Extractor extractor = new Extractor();
		extractor.run();
	}

}
