package persistencia.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import modelo.preguntas.Pregunta;
import modelo.usuario.Usuario;
import persistencia.impl.Connection;

import com.mongodb.DB;
import com.mongodb.DBObject;

public class GetUsuarios {
	
	Random r = new Random();
	
	@SuppressWarnings("unchecked")
	public List<Usuario> get(){
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		DB db = Connection.DatabaseConnection();
		List<DBObject> usuariosBase = db.getCollection("Users").find().toArray();
		Collections.shuffle(usuariosBase);
		for(DBObject user: usuariosBase){
				Usuario u = new Usuario(
						user.get("_id").toString(),
						user.get("password").toString(),
						user.get("nombre").toString(),
						user.get("apellidos").toString(),
						user.get("email").toString(),
						Integer.valueOf(user.get("edad").toString()),
						//partidas perdidas
						Integer.valueOf(user.get("numJugadas").toString()),
//						- Integer.valueOf(user.get("numGanadas").toString()),
						//partidas ganadas
						Integer.valueOf(user.get("numGanadas").toString()),
						//preguntas falladas
						Integer.valueOf(user.get("preguntasJugadas").toString()),
//						- Integer.valueOf(user.get("preguntasAcertadas").toString()),
						//preguntas acertadas
						Integer.valueOf(user.get("preguntasAcertadas").toString()));
//						Integer.valueOf(user.get("edad").toString()),
//						Integer.valueOf( r.nextInt(10)),
//						Integer.valueOf(r.nextInt(10)),
//						Integer.valueOf(r.nextInt(10)),
//						Integer.valueOf(r.nextInt(10)));
				usuarios.add(u);
		}
		return usuarios; 
		
	}
}
