package business.preguntas.impl;

import java.util.ArrayList;

import business.preguntas.ServicePreguntas;

public class SimpleServicePregunta implements ServicePreguntas {

	@Override
	public Pregunta getPregunta(String iD, String pregunta, ArrayList<String> respuestas,
			String respuestaCorrecta) {
		return new Pregunta(iD, pregunta, respuestas, respuestaCorrecta);
	}

}
