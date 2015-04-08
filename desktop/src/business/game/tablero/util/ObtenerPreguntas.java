package business.game.tablero.util;

import java.util.Collections;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBObject;

import persistencia.Connection;

public class ObtenerPreguntas {

	public static DBObject devolverPregunta(String categoria){
		DB db = Connection.DatabaseConnection();
		List<DBObject> preguntas = db.getCollection("Questions").find().toArray();
		Collections.shuffle(preguntas);
		for(DBObject pregunta: preguntas){
			if(pregunta.get("_id").toString().startsWith(categoria))
				return pregunta;
		}
		return null; 
		
	}
}
