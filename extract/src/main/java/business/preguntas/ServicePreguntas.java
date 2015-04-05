package business.preguntas;

import java.util.ArrayList;

import business.preguntas.impl.Pregunta;

public interface ServicePreguntas {

	Pregunta getPregunta(String iD, String pregunta, ArrayList<String> respuestas,
			String respuestaCorrecta);
}
