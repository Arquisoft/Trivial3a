package business.game.login.acciones;

import persistencia.impl.Connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public abstract class Action {
	
	private DB db;
	protected DBCollection coleccion;
	private boolean server_status;
	
	protected Action(){
		db = Connection.DatabaseConnection();
	}
	
	public DB getDb() {
		return db;
	}
	public void setDb(DB db) {
		this.db = db;
	}

	public DBCollection getColeccion() {
		return coleccion;
	}

	public void setColeccion(DBCollection coleccion) {
		this.coleccion = coleccion;
	}
	
	public boolean getServerStatus(){
		return server_status;
	}
	
	public void setServerStatus(boolean server_status){
		this.server_status = server_status;
	}

	public abstract Object execute();

}
