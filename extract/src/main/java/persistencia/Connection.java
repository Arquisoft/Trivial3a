package persistencia;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Connection {

	private final static String DB = "TrivialDB";
	
	/**
	 * Método que conecta la aplicación con el servidor
	 * @return base de datos con la que se desea trabajar
	 */
	public static DB DatabaseConnection(){
		MongoClient mongo;
		try {
			mongo = new MongoClient("localhost");
			return mongo.getDB(DB);
		} catch (Exception e) {
			System.out.println("No se ha podido realizar la conexión con la base de datos");
			return null;
		}
	} 

}
