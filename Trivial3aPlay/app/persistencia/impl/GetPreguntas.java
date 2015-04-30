package persistencia.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.preguntas.Pregunta;

import persistencia.impl.Connection;

import com.mongodb.DB;
import com.mongodb.DBObject;

public class GetPreguntas {

	
	
	@SuppressWarnings("unchecked")
	public Pregunta devolverPregunta(String categoria){
		DB db = Connection.DatabaseConnection();
		List<DBObject> preguntas = db.getCollection("Questions").find().toArray();
		Collections.shuffle(preguntas);
		for(DBObject pregunta: preguntas){
			if(pregunta.get("_id").toString().startsWith(categoria))
				return new Pregunta(pregunta.get("_id").toString(),pregunta.get("pregunta").toString(),(ArrayList<String>)pregunta.get("respuestasIncorrectas"),pregunta.get("respuestaCorrecta").toString());
		}
		return null; 
		
	}
}
