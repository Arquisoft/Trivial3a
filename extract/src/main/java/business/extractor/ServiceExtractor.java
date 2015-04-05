package business.extractor;

import business.extractor.impl.Extractor;
import business.extractor.impl.MenuExtractor;

public interface ServiceExtractor {

	Extractor getExtractor();
	
	MenuExtractor getMenuExtractor();
	
}
