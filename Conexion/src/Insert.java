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
import com.mongodb.MongoTimeoutException;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;

public class Insert {

	private static DB db;
	private static DBCollection collection;
	private static FileInputStream archivo;
	private final static String coll = "Questions";
	
	public static void main(String[] args) {
		try{
			db = Connection.DatabaseConnection();
			importJSON("Salida.JSON");
			insert(coll);
			getElements(coll);
		}catch(MongoTimeoutException e){
			System.out.println("El servidor no responde, compruebe su conexi�n");
		}

	}
	
	/**
	 * M�todo que permite cargar el fichero en el que se encuentran las preguntas
	 * @param path - Ruta para acceder al fichero
	 */
	public static void importJSON(String path){
		try{
			archivo = new FileInputStream(path);
		}catch(FileNotFoundException e){
			System.out.println("El archivo de preguntas no ha sido encontrado");
		}
	}
	
	/**
	 * M�todo que inserta las preguntas
	 * @throws MongoTimeoutException - No recibe respuesta del servidor
	 */
	public static void insert(String coll) throws MongoTimeoutException{
		BufferedReader br = new BufferedReader(new InputStreamReader(archivo));
		collection = db.getCollection(coll);
		String line;
		int cont = 0;
		try{
		while((line = br.readLine()) != null){
			try{
			cont++;
			DBObject obj = (DBObject) JSON.parse(line);
			if(obj != null)
				collection.insert(obj);
			}catch(DuplicateKeyException e){
				System.out.println("La pregunta de la l�nea "+cont+" ya se encuentra en la base de datos");
			}catch(JSONParseException e1){
				System.out.println("La l�nea "+cont+" se encuentra en un formato no v�lido");
			}
		}
		}catch(IOException e){
			System.out.println("Ha ocurrido un error al leer la l�nea "+cont);
		}
	}

	/**
	 * M�todo que limpia la colecci�n que se le pase por par�metro
	 * @param coll - Colecci�n que se desea limpiar
	 * @throws MongoTimeoutException - No recibe respuesta del servidor
	 */
	public static void clearCollection(String coll)throws MongoTimeoutException{
		db.getCollection(coll).drop();
	}
	
	/**
	 * M�todo que devuelve los elementos de una colecci�n
	 * @param coll - Colecci�n de la que se desean los elementos
	 * @throws MongoTimeoutException - No recibe respuesta del servidor
	 */
	public static void getElements(String coll)throws MongoTimeoutException{
		DBCursor cursor = db.getCollection(coll).find();
		int i=1;
        while (cursor.hasNext()) { 
	        System.out.println("Pregunta: "+i); 
	        System.out.println(cursor.next()); 
	        i++;
        }
	}
}
