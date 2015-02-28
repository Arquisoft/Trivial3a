import com.mongodb.DB;
import com.mongodb.MongoClient;


import java.net.UnknownHostException;


public class Connection {

	public static DB DatabaseConnection(){
		MongoClient mongo;
		try {
			mongo = new MongoClient("localhost");
			return mongo.getDB("TrivialDB");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;
		}
	} 

}
