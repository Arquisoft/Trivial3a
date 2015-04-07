package business.game.login.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import modelo.usuario.Usuario;
import business.game.login.acciones.Action;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


public class EstadisticasAction extends Action{
	
	String campo;
	String valor;
	DBObject query;
	BasicDBObject obj;
	
	public EstadisticasAction(String campo, String valor) {
		super();
		this.campo = campo;
		this.valor = valor;
	}

	@Override
	public List<Usuario> execute() {
		List<Usuario> filtrados = new ArrayList<Usuario>();
		coleccion = getDb().getCollection("Users");
		BasicDBObject q = new BasicDBObject();
		if(campo.toLowerCase().equals("login"))
			q.put("_id",  java.util.regex.Pattern.compile(valor));
		else
			q.put(campo.toLowerCase(),  java.util.regex.Pattern.compile(valor));
		DBCursor cursor =  coleccion.find(q);
	    while (cursor.hasNext()) {
	    	obj = (BasicDBObject) cursor.next();
	    	filtrados.add(getUsuario(obj));
	    }
		
		return filtrados;
	}
	
	private Usuario getUsuario(BasicDBObject obj){
		Usuario u = new Usuario(obj.getString("_id"),
				obj.getString("password"),
				obj.getString("nombre"),
				obj.getString("apellidos"),
				obj.getString("email"),
				obj.getInt("edad"),
				obj.getInt("numJugadas"),
				obj.getInt("numGanadas"),
				obj.getInt("preguntasJugadas"),
				obj.getInt("preguntasAcertadas"));
		return u;
	}

}
