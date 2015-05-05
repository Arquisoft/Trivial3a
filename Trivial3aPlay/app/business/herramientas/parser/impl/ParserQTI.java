package business.herramientas.parser.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.preguntas.Pregunta;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;


public class ParserQTI extends Parser{

	public ParserQTI(String nombreArchivo) {
		super(nombreArchivo);
	}

	public HashMap<String, Pregunta> getPregunta() throws IOException {

		HashMap<String, Pregunta> preguntas = new HashMap<String,Pregunta>(); // preguntas

		// preparacion de los parametros de lectura
		File archivo = new File(nombreArchivo);
		SAXBuilder constructor = new SAXBuilder();
		
		try {		
			String ID = "";
			String pregunta = "";
			ArrayList<String> respuestas = new ArrayList<String>();
			String respuestaCorrecta = "";
			
			Document xml = (Document) constructor.build(archivo);
			Element nodoRaiz = xml.getRootElement();
			List<Element> listaPreguntas = nodoRaiz.getChildren("itemBody", nodoRaiz.getNamespace()); //Obtener todas las preguntas
			List<Element> listaRespuestas = nodoRaiz.getChildren("responseDeclaration", nodoRaiz.getNamespace()); //Obtener lista de respuestas
			Element nodoPregunta = null;
			String idRespuestaCorrecta = "";
			
			for (int i=0; i< listaPreguntas.size(); i++) { // Para cada pregunta 
				nodoPregunta = listaPreguntas.get(i).getChild("choiceInteraction", nodoRaiz.getNamespace());
				ID = nodoPregunta.getAttributeValue("responseIdentifier"); //Obtener ID
				pregunta = nodoPregunta.getChildText("prompt", nodoRaiz.getNamespace()); //Obtener el texto de la pregunta
				idRespuestaCorrecta = getIDRespuestaCorrecta(listaRespuestas, ID, nodoRaiz.getNamespace()); //Obtiene el id de la respuesta correcta
				
				for(Element respuesta : nodoPregunta.getChildren("simpleChoice", nodoRaiz.getNamespace())){ //Obtener todas las respuestas a la pregunta y clasificarlas
					if(respuesta.getAttributeValue("identifier").equals(idRespuestaCorrecta))
						respuestaCorrecta = respuesta.getText();
					else	
						respuestas.add(respuesta.getText());
				}
				preguntas.put(ID, new Pregunta(ID, pregunta, respuestas, respuestaCorrecta));
				
				ID = "";
				pregunta = "";
				respuestas = new ArrayList<String>();
				respuestaCorrecta = "";
				nodoPregunta = null;
			}
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }	
		return preguntas;
	}
	
	/*
	 * Retorna el identificador de la respuesta correcta dado un id de pregunta
	 * @param El id de la pregunta, la lista de respuestas y el namespace del xml
	 * @return El id de la respuesta correcta
	 */
	private String getIDRespuestaCorrecta(List<Element> respuestas, String IDPregunta, Namespace nameSpace){
		String idRespuesta = "";
		String identifier;
		for(Element respuesta: respuestas){
			identifier = respuesta.getAttributeValue("identifier");
			if(IDPregunta.equals(identifier)){
				idRespuesta = respuesta.getChild("correctResponse", nameSpace).getChildText("value", nameSpace);
			}
		}
		return idRespuesta;
	}
}
