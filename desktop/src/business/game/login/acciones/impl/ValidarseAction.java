package business.game.login.acciones.impl;


import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import business.game.login.Partida;
import business.game.login.acciones.Action;
import business.game.tablero.colores.Color;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ValidarseAction extends Action{
	
	private String message;
	public String login;
	public String password;
	public Color color;
	private boolean isAdmin;

	
	DBObject query;
	BasicDBObject obj;
	
	public ValidarseAction(String login, String password, Color color){
		super();
		this.login = login;
		this.password = password;
		this.color = color;
		isAdmin = false;
		if(login.equals("admin") && password.equals("admin"))
			isAdmin = true;
		else{
			coleccion = getDb().getCollection("Users");
			query = new BasicDBObject();
			query.put("_id", login);
			query.put("password", password);
			try{
				obj = (BasicDBObject) coleccion.findOne(query);
				setServerStatus(true);
			}catch(Exception e){
				setServerStatus(false);
			}
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
	/**
	 * numJugadas= numero de partidas jugadas, numGanadas = numero de partidas ganadas
	 * @param obj
	 * @return
	 */
	private Usuario getUsuario(BasicDBObject obj){
		Usuario u = new Usuario(obj.getString("_id"),
				obj.getString("password"),
				obj.getString("nombre"),
				obj.getString("apellidos"),
				obj.getString("email"),
				obj.getInt("edad"),
				obj.getInt("numJugadas"),
				obj.getInt("numGanadas"));
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
	
	public boolean getIsAdmin(){
		return isAdmin;
	}
	
	public String getMessage(){
		return this.message;
	}

}
