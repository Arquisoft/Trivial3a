package persistencia.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.preguntas.Pregunta;
import modelo.usuario.Usuario;
import persistencia.impl.Connection;

import com.mongodb.DB;
import com.mongodb.DBObject;

public class GetUsuario {
	
	
	@SuppressWarnings("unchecked")
	public Usuario getUsuario(String login){
		DB db = Connection.DatabaseConnection();
		List<DBObject> usuarios = db.getCollection("Users").find().toArray();
		Collections.shuffle(usuarios);
		for(DBObject user: usuarios){
			if(user.get("_id").toString().equals(login))
				return new Usuario(
						user.get("_id").toString(),
						user.get("password").toString(),
						user.get("nombre").toString(),
						user.get("apellidos").toString(),
						user.get("email").toString(),
						Integer.valueOf(user.get("edad").toString()),
						Integer.valueOf(user.get("numJugadas").toString()),
						Integer.valueOf(user.get("numGanadas").toString()),
						Integer.valueOf(user.get("preguntasAcertadas").toString()),
						Integer.valueOf(user.get("preguntasJugadas").toString()));
		}
		return null; 
		
	}
}
