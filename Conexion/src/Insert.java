import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;



public class Insert {

	private static DB db;
	private static DBCollection collection;
	private static FileInputStream archivo;
	
	public static void main(String[] args) {
		db = Connection.DatabaseConnection();
		collection = db.getCollection("Questions");
		importJSon("");
		insert();
		getElements();

	}
	
	public static void importJSon(String path){
		try{
			archivo = new FileInputStream("P.JSON");
		}catch(FileNotFoundException e){
			System.out.println("El archivo de preguntas no ha sido encontrado");
		}
	}
	
	public static void insert(){
		BufferedReader br = new BufferedReader(new InputStreamReader(archivo));
		String line;
		int cont = 0;
		try{
		while((line = br.readLine()) != null){
			try{
			cont++;
			DBObject obj = (DBObject) JSON.parse(line);
			collection.insert(obj);
			}catch(DuplicateKeyException e){
				System.out.println("La pregunta de la línea "+cont+" ya se encuentra en la base de datos");
			}catch(JSONParseException e1){
				System.out.println("La línea "+cont+" se encuentra en un formato no válido");
			}
		}
		}catch(IOException e){
			System.out.println("Ha ocurrido un error al leer la línea "+cont);
		}
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
