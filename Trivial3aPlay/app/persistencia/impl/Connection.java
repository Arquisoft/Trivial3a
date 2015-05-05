package persistencia.impl;

import com.mongodb.*;

public class Connection {

	private final static String DB = "trivialdb";
	
	/**
	 * Método que conecta la aplicación con el servidor
	 * @return base de datos con la que se desea trabajar
	 */

	public static DB DatabaseConnection(){
		MongoClient mongo;
		try {
			MongoClientURI uri  = new MongoClientURI("mongodb://lili:lili@ds031842.mongolab.com:31842/trivialdb"); 
	        mongo = new MongoClient(uri);
			//mongo = new MongoClient("localhost");
			return mongo.getDB(uri.getDatabase());
		} catch (Exception e) {
			System.out.println("No se ha podido realizar la conexión con la base de datos");
			return null;
		}
	} 

}
