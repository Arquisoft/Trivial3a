package parser;

import java.io.IOException;
import java.util.HashMap;

import preguntas.Pregunta;

public  abstract class Parser {

	protected String nombreArchivo;

	public Parser(String string) {
		this.nombreArchivo = string;
	}
	
	public abstract HashMap<String, Pregunta> getPregunta() throws IOException;
}
