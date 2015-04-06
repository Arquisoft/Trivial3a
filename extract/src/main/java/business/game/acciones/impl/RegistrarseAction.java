package business.game.acciones.impl;


import javax.swing.JOptionPane;


import business.game.acciones.Action;
import business.game.logica.Usuario;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoTimeoutException;

public class RegistrarseAction extends Action{
	
	private final static String EXITO ="�Gracias por unirte!";
	private final static String DUPLICADO = "Lo sentimos, ese usuario ya est� en uso";
	private Usuario u;
	
	
	public RegistrarseAction(String login, String password, String nombre, 
			String apellidos, String email, int edad){
		super();
		u = new Usuario(login, password, nombre, apellidos, 
				email, edad);
	}
	
	public RegistrarseAction(String user,String email){
		super();
		u = new Usuario(user,"","","",email,0);
	}

	@Override
	public String execute() {
		coleccion = getDb().getCollection("Users");
		
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
	
	public boolean existUsernameEmail(){
		try{
			coleccion = getDb().getCollection("Users");
			DBObject queryNombre = new BasicDBObject();
			DBObject queryEmail = new BasicDBObject();
			queryNombre.put("_id", u.getLogin());
			queryEmail.put("email", u.getEmail());
			BasicDBObject objNombre = (BasicDBObject) coleccion.findOne(queryNombre);
			BasicDBObject objEmail = (BasicDBObject) coleccion.findOne(queryEmail);
			setServerStatus(true);
			return (objNombre==null && objEmail==null ? false : true);
		}catch(MongoTimeoutException e){
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error con la base de datos, vuelva a intentarlo.");
			setServerStatus(false);
			return false;
		}
		
	}
}
