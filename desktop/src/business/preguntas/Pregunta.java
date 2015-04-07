package business.preguntas;


import java.util.ArrayList;
import java.util.Comparator;

public class Pregunta {

	private String _id;
	private String pregunta;
	private ArrayList<String> respuestasIncorrectas;
	private String respuestaCorrecta;

	public Pregunta(String iD, String pregunta, ArrayList<String> respuestas,
			String respuestaCorrecta) {
		super();
		_id = iD;
		this.pregunta = pregunta;
		this.respuestasIncorrectas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getID() {
		return _id;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public ArrayList<String> getRespuestasIncorrectas() {
		return respuestasIncorrectas;
	}
	public void setRespuestasIncorrectas(ArrayList<String> respuestasIncorrectas) {
		this.respuestasIncorrectas = respuestasIncorrectas;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pregunta other = (Pregunta) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "Pregunta [pregunta=" + pregunta + 
				 ", respuestaCorrecta=" + respuestaCorrecta + ", respuestasIncorrectas=";
		for(String sa : respuestasIncorrectas)
			s+=sa+", ";
		return s+="]";
	}
	
	

}
