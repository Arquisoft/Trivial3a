package persistencia.impl;

import java.util.Collections;
import java.util.List;

import persistencia.impl.Connection;

import com.mongodb.DB;
import com.mongodb.DBObject;

public class GetPreguntas {

	
	
	public DBObject devolverPregunta(String categoria){
		DB db = Connection.DatabaseConnection();
//		DB db = Factories.persistence.
		List<DBObject> preguntas = db.getCollection("Questions").find().toArray();
		Collections.shuffle(preguntas);
		for(DBObject pregunta: preguntas){
			if(pregunta.get("_id").toString().startsWith(categoria))
				return pregunta;
		}
		return null; 
		
	}
}
