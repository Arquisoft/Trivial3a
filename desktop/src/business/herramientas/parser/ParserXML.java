package business.herramientas.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.preguntas.Pregunta;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class ParserXML extends Parser{

	public ParserXML(String nombreArchivo) {
		super(nombreArchivo);
	}

	public HashMap<String, Pregunta> getPregunta() throws IOException {

		HashMap<String, Pregunta> preguntas = new HashMap<>(); // preguntas

		// preparacion de los parametros de lectura
		File archivo = new File(nombreArchivo);
		SAXBuilder constructor = new SAXBuilder();
		
		try {		
			String ID = "";
			String pregunta = "";
			ArrayList<String> respuestas = new ArrayList<>();
			String respuestaCorrecta = "";
			
			Document xml = (Document) constructor.build(archivo);
			Element nodoRaiz = xml.getRootElement();
			List<Element> listaPreguntas = nodoRaiz.getChildren("pregunta"); //Obtener todas las preguntas
			for (Element nodoPregunta : listaPreguntas) { // Para cada pregunta 
				ID = nodoPregunta.getAttributeValue("id"); //Obtener ID
				pregunta = nodoPregunta.getChildText("textoPregunta"); //Obtener el texto de la pregunta
				for(Element respuestaIncorrecta : nodoPregunta.getChildren("respuestaIncorrecta")){ //Obtener todas las respuestas incorrectas
					respuestas.add(respuestaIncorrecta.getText());
				}
				respuestaCorrecta = nodoPregunta.getChildText("respuestaCorrecta");//Obtener la respuesta correcta
				preguntas.put(ID, new Pregunta(ID, pregunta, respuestas, respuestaCorrecta));
				
				ID = "";
				pregunta = "";
				respuestas = new ArrayList<>();
				respuestaCorrecta = "";
			}
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }	
		return preguntas;
	}
}
