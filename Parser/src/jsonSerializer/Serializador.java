package jsonSerializer;

import java.util.HashMap;

import preguntas.Pregunta;

public interface Serializador {
	
		public void createFile(HashMap<String,Pregunta> preguntas, String localizacion);
}
