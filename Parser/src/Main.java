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
		Parser p;
		JsonSerialImpl j = new JsonSerialImpl();
		p = new ParserGIFT(s.nextLine());
		
//		p = new ParserQTI(s.nextLine());
		try {
			HashMap<String,Pregunta> preguntasFinal = p.getPregunta();
			for(Entry<String, Pregunta> entry : preguntasFinal.entrySet())
				System.out.println(entry.toString());
			
			j.createFile(preguntasFinal,"Salida.JSON");
		} catch (FileNotFoundException e){
			System.out.println("No existe el archivo.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.close();
		
	}

}
