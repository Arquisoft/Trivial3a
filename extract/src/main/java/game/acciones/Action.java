package game.acciones;

import persistencia.impl.Connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public abstract class Action {
	
	private DB db;
	protected DBCollection coleccion;
	
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

	public abstract Object execute();

}
