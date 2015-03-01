package jsonSerializer;

import java.util.HashMap;

import preguntas.Pregunta;

public interface JsonSerial {
	
		public void createFile(HashMap<String,Pregunta> preguntas, String localizacion);
}
