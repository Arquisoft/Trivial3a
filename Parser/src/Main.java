import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import jsonSerializer.Impl.JsonSerialImpl;

import parser.Parser;
import parser.ParserGIFT;
import parser.ParserQTI;
import parser.ParserXML;
import preguntas.Pregunta;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Inserte el Nombre del Fichero de Preguntas.");
		Parser p = null;
		JsonSerialImpl j = new JsonSerialImpl();
		String orden = s.nextLine();
		
		if(orden.contains(".GIFT"))
			p = new ParserGIFT(orden);
		else if(orden.contains(".XML"))
			p = new ParserQTI(orden);
		
		try {
			HashMap<String, Pregunta> preguntasFinal = p.getPregunta();
			for (Entry<String, Pregunta> entry : preguntasFinal.entrySet())
				System.out.println(entry.toString());

			j.createFile(preguntasFinal, "Salida.JSON");
		} catch (FileNotFoundException e) {
			System.err.println("No existe el archivo.");
		} catch (IOException e) {
			System.err.println("No se ha podido realizar la operación.");
		}
		s.close();

	}

}
