package business.serializador.impl;

import java.util.HashMap;

import business.preguntas.Pregunta;


public interface Serializador {
	
		public void createFile(HashMap<String,Pregunta> preguntas, String localizacion);
}
