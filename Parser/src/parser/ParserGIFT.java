package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import preguntas.Pregunta;

public class ParserGIFT extends Parser{

	public ParserGIFT(String nombreArchivo) {
		super(nombreArchivo);
	}

	public HashMap<String, Pregunta> getPregunta() throws IOException {

		HashMap<String, Pregunta> preguntas = new HashMap<>(); // preguntas

		// preparacion de los parametros de lectura
		File archivo = new File(nombreArchivo);
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		// Creacion de parametros para las preguntas
		String ID = "";
		String pregunta = "";
		ArrayList<String> respuestas = new ArrayList<>();
		String respuestaCorrecta = "";

		String linea;
		while ((linea = br.readLine()) != null) {

			// System.out.println(linea); //Solo para Debug

			if (linea.contains(":")) {// ID de la pregunta
				ID = linea.split("::")[1];
				linea = br.readLine();
			}

			else if (linea.contains("{")) {// Texto de la pregunta
				pregunta = linea.replace('{', ' ');
				linea = br.readLine();
			}

			else if (linea.contains("~")) { // respuesta Incorrecta (entrara 3
											// veces)
				respuestas.add(linea.split("~")[1]);
				if (respuestas.size() == 3 && respuestaCorrecta != "") {
					preguntas.put(ID, new Pregunta(ID, pregunta, respuestas,
							respuestaCorrecta));
					ID = "";
					pregunta = "";
					respuestaCorrecta = "";
					respuestas = new ArrayList<>();
				}
			}

			else if (linea.contains("=")) { // respuesta correcta
				respuestaCorrecta = linea.split("=")[1];
				if (respuestas.size() == 3) {
					preguntas.put(ID, new Pregunta(ID, pregunta, respuestas,
							respuestaCorrecta));
					ID = "";
					pregunta = "";
					respuestaCorrecta = "";
					respuestas = new ArrayList<>();
				}
			}

		}
		br.close();
		return preguntas;
	}
}
