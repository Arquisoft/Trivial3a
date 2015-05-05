package modelo;

import java.util.ArrayList;

import modelo.preguntas.Pregunta;
import modelo.usuario.Usuario;

public class SimpleServiceModelo implements ServiceModelo {

	@Override
	public Pregunta getPregunta(String iD, String pregunta, ArrayList<String> respuestas,
			String respuestaCorrecta) {
		return new Pregunta(iD, pregunta, respuestas, respuestaCorrecta);
	}

	@Override
	public Usuario getUsuario() {
		return new Usuario();
	}

}
