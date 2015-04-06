package business.game.login.acciones.impl;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import business.game.login.Partida;
import business.game.login.Usuario;
import business.game.login.acciones.Action;
import business.game.login.acciones.util.ColorEnum;

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
		try{
			coleccion = getDb().getCollection("Partida");
			
			DBObject objeto= new BasicDBObject();
			objeto.put("_id", nextId());
			Iterator<Entry<ColorEnum, Usuario>> it = partida.entrySet().iterator();
			while (it.hasNext()) {
				Entry<ColorEnum, Usuario> e = it.next();
				objeto.put(e.getKey().toString(), e.getValue().getLogin());
			}
			coleccion.insert(objeto);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error con la base de datos, vuelva a intentarlo.");
		}
		return null;
	}
	
	public int nextId(){
		long actual = coleccion.count();
		return (int) (actual + 1);
	}

}
