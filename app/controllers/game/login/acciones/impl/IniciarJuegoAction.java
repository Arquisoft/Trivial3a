package business.game.login.acciones.impl;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import presentacion.game.DesktopLauncher;
import business.game.login.Partida;
import business.game.login.acciones.Action;
import business.game.tablero.colores.Color;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class IniciarJuegoAction extends Action{
	
	private Map<Color, Usuario> partida;
	
	public IniciarJuegoAction() {
		super();
		partida = Partida.getPartida();
	}
	
	@Override
	public Object execute() {
		
//			coleccion = getDb().getCollection("Partida");
//			
//			DBObject objeto= new BasicDBObject();
//			objeto.put("_id", nextId());
//			Iterator<Entry<Color, Usuario>> it = partida.entrySet().iterator();
//			while (it.hasNext()) {
//				Entry<Color, Usuario> e = it.next();
//				objeto.put(e.getKey().toString(), e.getValue().getLogin());
//			}
//			coleccion.insert(objeto);
			DesktopLauncher.jugadores=partida;//Pasamos el control al DesktopLauncher de libgdx y los jugadores con sus colores.
			DesktopLauncher.main(new String[0]);
		
		return null;
	}
	
	public int nextId(){
		long actual = coleccion.count();
		return (int) (actual + 1);
	}

}
