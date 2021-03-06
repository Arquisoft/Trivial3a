package game.acciones.impl;

import game.acciones.Action;
import game.acciones.util.ColorEnum;
import game.logica.Partida;
import game.logica.Usuario;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class IniciarJuegoAction extends Action{
	
	private Map<ColorEnum, Usuario> partida;
	
	public IniciarJuegoAction() {
		super();
		partida = Partida.getPartida();
	}
	
	@Override
	public Object execute() {
		coleccion = getDb().getCollection("Partida");
		
		DBObject objeto= new BasicDBObject();
		objeto.put("_id", nextId());
		Iterator<Entry<ColorEnum, Usuario>> it = partida.entrySet().iterator();
		while (it.hasNext()) {
			Entry<ColorEnum, Usuario> e = it.next();
			objeto.put(e.getKey().toString(), e.getValue().getLogin());
		}
		coleccion.insert(objeto);
		
		return null;
	}
	
	public int nextId(){
		long actual = coleccion.count();
		return (int) (actual + 1);
	}

}
