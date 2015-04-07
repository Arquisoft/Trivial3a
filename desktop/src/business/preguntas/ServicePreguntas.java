package business.preguntas;

import java.util.ArrayList;

import business.preguntas.impl.Pregunta;
/**
 * Factoria encargada de la creacion de las Preguntas
 * @author Inigo Llaneza Aller
 *
 */
public interface ServicePreguntas {

	/**
	 * Creacion de Preguntas
	 * @param iD idPregunta
	 * @param pregunta textoPregunta
	 * @param respuestas respuestasIncorrectas
	 * @param respuestaCorrecta respuestaCorrecta
	 * @return Pregunta 
	 */
	Pregunta getPregunta(String iD, String pregunta, ArrayList<String> respuestas,
			String respuestaCorrecta);
}
