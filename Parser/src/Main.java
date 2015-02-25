import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import parser.Parser;
import preguntas.Pregunta;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Inserte el Nombre del Fichero de Preguntas.");
		Parser p = new Parser(s.nextLine());
		try {
			HashMap<String,Pregunta> preguntasFinal = p.getPregunta();
			for(Entry<String, Pregunta> entry : preguntasFinal.entrySet())
				System.out.println(entry.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
		
	}

}
