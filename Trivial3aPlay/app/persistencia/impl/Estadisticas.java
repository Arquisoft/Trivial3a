package persistencia.impl;

import play.cache.Cache;
import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;


public class Estadisticas {
	public static JuegoEnTableroLineal juego;
	public static DBCollection estadisticas;
	
	public void setJuego(JuegoEnTableroLineal juego){
		Estadisticas.juego = juego;
	}
	
	public static void actualizar(String option){
		String login = juego.getActual().getUsuario().getLogin();
		estadisticas = Connection.DatabaseConnection().getCollection("estadisticas");
		DBObject jugador  = estadisticas.findOne(login);
		if(jugador == null) 
			estadisticas.insert(crearJugador());
		else{
			BasicDBObject query = new BasicDBObject("_id",login);
			jugador = estadisticas.findOne(query);
			BasicDBObject queryUpdate = actualizacion(option,login);
			estadisticas.update(query,queryUpdate);
		}
	}
	
	public static BasicDBObject actualizacion(String option,String login){
		BasicDBObject query = new BasicDBObject();
		switch(option){
			case "numJugadas": query.put("$inc", val)
				break;
		}
		
		return query;
	}
	public static DBObject crearJugador(){
		DBObject jugador = new BasicDBObject();
		jugador.put("_id",juego.getActual().getUsuario().getLogin());
		jugador.put("numJugadas",0);
		jugador.put("numGanadas",0);
		jugador.put("partidasJugadas",0);
		jugador.put("partidasGanadas",0);
		return jugador;
	}
	}
