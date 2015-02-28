
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;



public class Insert {

	private static DB db;
	private static DBCollection collection;
	
	public static void main(String[] args) {
		db = Connection.DatabaseConnection();
		insertQuestions();
		getElements();

	}
	
	public static void insertQuestions(){
		collection = db.getCollection("T");
		db.command("mongoimport --db TrivialDB --collection T --file Prueba.JSON");	
		System.out.println("Hay "+collection.count()+" preguntas en esta colección");

	}

	/*
	 * Limpia la colleción
	 */
	public static void clearCollection(){
		collection.drop();
	}
	
	
	public static void getElements(){
		DBCursor cursor = collection.find();
		int i=1;
        while (cursor.hasNext()) { 
	        System.out.println("Inserted Element: "+i); 
	        System.out.println(cursor.next()); 
	        i++;
        }
	}
}
