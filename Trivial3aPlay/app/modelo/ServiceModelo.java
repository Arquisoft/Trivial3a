package modelo;

import java.util.ArrayList;

import modelo.preguntas.Pregunta;
import modelo.usuario.Usuario;
/**
 * Factoria encargada de la creacion de las Preguntas
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceModelo {

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
	/**
	 * Creacion de Usuario
	 * @return instancia de usuario
	 */
	Usuario getUsuario();
}
