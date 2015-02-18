import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import parser.Parser;
import preguntas.Pregunta;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Inserte el Nombre del Fichero de Preguntas.");
		Parser p = new Parser(s.nextLine());
		try {
			ArrayList<Pregunta> preguntasFinal = p.getPregunta();
			for(Pregunta pr : preguntasFinal)
				System.out.println(pr.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.close();
		
	}

}
