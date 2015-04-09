package game.acciones.impl;

import game.acciones.Action;
import game.logica.Usuario;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DuplicateKeyException;

public class RegistrarseAction extends Action{
	
	private final static String EXITO ="¡Gracias por unirte!";
	private final static String DUPLICADO = "Lo sentimos, ese Login ya está siendo usado";
	private Usuario u;
	
	
	public RegistrarseAction(String login, String password, String nombre, 
			String apellidos, String email, int edad){
		super();
		u = new Usuario(login, password, nombre, apellidos, 
				email, edad);
	}

	@Override
	public String execute() {
		coleccion = getDb().getCollection("Usuario");
		
		try{
			DBObject objeto= new BasicDBObject();
			objeto.put("_id", u.getLogin() );
			objeto.put("password",u.getPassword());
			objeto.put("nombre",u.getNombre());
			objeto.put("apellidos",u.getApellidos());
			objeto.put("email",u.getEmail());
			objeto.put("edad",u.getEdad());
			coleccion.insert(objeto);
			return EXITO;
		}catch(DuplicateKeyException e){
			return DUPLICADO;
		}
	}
}
