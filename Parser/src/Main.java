import java.util.Scanner;

import extractor.Extractor;

public class Main {

	public static void main(String[] args) {
		Scanner s = new  Scanner(System.in);
		System.out.println("Inserte el nombre del fichero.");
		Extractor  e = new Extractor();
		e.setFile(s.nextLine());
		e.run();
	}

}
