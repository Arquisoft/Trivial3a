package game.acciones.impl;

import game.acciones.Action;
import game.acciones.util.Color;
import game.logica.Partida;
import game.logica.Usuario;

import java.util.Iterator;
import java.util.Map.Entry;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ValidarseAction extends Action{
	
	private String message;
	public String login;
	public String password;
	public Color color;
	
	DBObject query;
	BasicDBObject obj;
	
	public ValidarseAction(String login, String password, Color color){
		super();
		this.login = login;
		this.password = password;
		this.color = color;
		
		coleccion = getDb().getCollection("Usuario");
		query = new BasicDBObject();
		query.put("_id", login);
		query.put("password", password);
		obj = (BasicDBObject) coleccion.findOne(query);
		
	}

	@Override
	public Object execute() {
		
		if(isCorrecto()){
			Usuario u = getUsuario(obj);
			Partida.addUsuario(color, u);
		}
		return null;
	}
	
	private Usuario getUsuario(BasicDBObject obj){
		Usuario u = new Usuario(obj.getString("_id"),
				obj.getString("password"),
				obj.getString("nombre"),
				obj.getString("apellidos"),
				obj.getString("email"),
				obj.getInt("edad"));
		return u;
	}
	
	private boolean usuarioDuplicado(Usuario u){
		Iterator<Entry<Color, Usuario>> it = Partida.getPartida().entrySet().iterator();
		while (it.hasNext()) {
			Entry<Color, Usuario> e = it.next();
			String login = e.getValue().getLogin();
			if(login.equals(u.getLogin())){
				
				return true;
			}
		}
		return false;
	}
	
	public boolean isCorrecto(){
		if(obj!= null){
			Usuario u = getUsuario(obj);
			if(!Partida.getPartida().containsKey(color))
				if(!usuarioDuplicado(u))
					return true;
				else
					message="Este usuario ya ha sido registrado para esta partida";
			else
				message="El color elegido ya ha sido seleccionado";
					
		}
		else{
			message="Usuario o contraseña incorrectos";
		}
		return false;
	}
	
	public String getMessage(){
		return this.message;
	}

}
