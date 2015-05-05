package persistencia.impl;

import java.util.ArrayList;
import java.util.List;

import modelo.usuario.Usuario;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;


public class Estadisticas {
	public static JuegoEnTableroLineal juego;
	public static DBCollection estadisticas;
	
	
	
	public static void setJuego(JuegoEnTableroLineal juego){
		Estadisticas.juego = juego;
	}
	
	public static void inicializar(){
		for(Jugador j : juego.getQueueJugadores()){
			actualizacion("numJugadas",j.getUsuario().getLogin());
		}
	}
	
	public static void actualizar(String option){
		String login = juego.getActual().getUsuario().getLogin();
		actualizacion(option,login);			
	}
	
	private static void actualizacion(String option,String login){
		estadisticas = Connection.DatabaseConnection().getCollection("Users");
		BasicDBObject queryID = new BasicDBObject("_id",login);
		BasicDBObject  query = null;
		switch(option){
			case "numJugadas": 		query = new BasicDBObject("$inc",new BasicDBObject("numJugadas",1));
									break;
			case "numGanadas": 		query = new BasicDBObject("$inc",new BasicDBObject("numGanadas",1));
									break;
			case "preguntasJugadas": query = new BasicDBObject("$inc",new BasicDBObject("preguntasJugadas",1));
									break;
			case "preguntasAcertadas": query = new BasicDBObject("$inc",new BasicDBObject("preguntasAcertadas",1));
									break;
			default:
									return;
		}	
		estadisticas.update(queryID,query);
		System.out.println("Probando pregJugadas:"+estadisticas.findOne(queryID).get("preguntasJugadas"));
		System.out.println("Probando pregAcertadas:"+estadisticas.findOne(queryID).get("preguntasAcertadas"));

	}
	public static DBObject crearJugador(){
		DBObject jugador = new BasicDBObject();
		jugador.put("_id",juego.getActual().getUsuario().getLogin());
		jugador.put("numJugadas",0);
		jugador.put("numGanadas",0);
		jugador.put("partidasJugadas",1);
		jugador.put("partidasGanadas",0);
		return jugador;
	}
	
	public static List<Usuario> estadisticasJugadores(){
		DBCursor cursor = estadisticas.find();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		while(cursor.hasNext()){
			DBObject obj = cursor.curr();
			Usuario u = new Usuario((String)obj.get("_id"),(int)obj.get("numJugadas"),(int) obj.get("numGanadas"),
					(int) obj.get("preguntasJugadas"),(int) obj.get("preguntasAcertadas"));
			listaUsuario.add(u);
			cursor.next();
		}
		return listaUsuario;
	}
	
	}
