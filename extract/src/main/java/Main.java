import infraestructura.Factories;
import business.extractor.impl.Extractor;

public class Main {

	public static void main(String[] args) {
		Extractor e = Factories.services.createServiceExtractor().getExtractor();
		e.run();
	}

}
