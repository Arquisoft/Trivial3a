package business.herramientas.serializador;

import java.util.HashMap;

import modelo.preguntas.Pregunta;


public interface Serializador {
	
		public void createFile(HashMap<String,Pregunta> preguntas, String localizacion);
}
