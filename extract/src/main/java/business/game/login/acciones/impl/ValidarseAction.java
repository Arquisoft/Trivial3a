package business.game.login.acciones.impl;


import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import business.game.login.acciones.Action;
import business.game.login.acciones.util.ColorEnum;
import business.game.login.logica.Partida;
import business.game.login.logica.Usuario;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoTimeoutException;

public class ValidarseAction extends Action{
	
	private String message;
	public String login;
	public String password;
	public ColorEnum color;

	
	DBObject query;
	BasicDBObject obj;
	
	public ValidarseAction(String login, String password, ColorEnum color){
		super();
		this.login = login;
		this.password = password;
		this.color = color;
		
		coleccion = getDb().getCollection("Users");
		query = new BasicDBObject();
		query.put("_id", login);
		query.put("password", password);
		try{
			obj = (BasicDBObject) coleccion.findOne(query);
			setServerStatus(true);
		}catch(MongoTimeoutException e){
			setServerStatus(false);
		}
		
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
		Iterator<Entry<ColorEnum, Usuario>> it = Partida.getPartida().entrySet().iterator();
		while (it.hasNext()) {
			Entry<ColorEnum, Usuario> e = it.next();
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
					JOptionPane.showMessageDialog(null, "Este usuario ya ha sido registrado para esta partida");
			else
				JOptionPane.showMessageDialog(null, "El color elegido ya ha sido seleccionado");
					
		}
		else if(!getServerStatus()){
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error con la base de datos, vuelva a intentarlo.");
		}
		else
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		return false;
	}
	
	
	public String getMessage(){
		return this.message;
	}

}
