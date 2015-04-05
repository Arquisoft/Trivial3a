package business.preguntas;

import java.util.ArrayList;

public interface ServicePreguntas {

	Pregunta getPregunta(String iD, String pregunta, ArrayList<String> respuestas,
			String respuestaCorrecta);
}
