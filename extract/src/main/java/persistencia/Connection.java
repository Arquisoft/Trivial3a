package persistencia;

import com.mongodb.DB;
import com.mongodb.MongoClient;


import java.net.UnknownHostException;

public class Connection {

	private final static String DB = "TrivialDB";
	
	/**
	 * M�todo que conecta la aplicaci�n con el servidor
	 * @return base de datos con la que se desea trabajar
	 */
	public static DB DatabaseConnection(){
		MongoClient mongo;
		try {
			mongo = new MongoClient("localhost");
			return mongo.getDB(DB);
		} catch (UnknownHostException e) {
			System.out.println("No se ha podido realizar la conexi�n con la base de datos");
			return null;
		}
	} 

}
