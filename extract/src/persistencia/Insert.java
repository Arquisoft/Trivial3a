package persistencia;

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
	
	/**
	 * Constructor de la clase insert donde se encuentra el esqueleto
	 * en el que se conecta a la base de datos, importa el JSON obtenido
	 * en pasos anteriores e inserta en la colecci�n elegida
	 * @param ruta
	 */
	public Insert(String ruta){
		try{
			db = Connection.DatabaseConnection();
			importJSON(ruta);
			insert(coll);
		}catch(MongoTimeoutException e){
			System.out.println("El servidor no responde, compruebe su conexi�n");
		}
	}
	/**
	 * Metodo que permite cargar el fichero en el que se encuentran las preguntas
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
	 * Metodo que inserta las preguntas
	 * @throws MongoTimeoutException - No recibe respuesta del servidor
	 */
	public static void insert(String coll) throws MongoTimeoutException{
		BufferedReader br = new BufferedReader(new InputStreamReader(archivo));
		collection = db.getCollection(coll);
		String line;
		DBObject obj = null;
		int cont = 0;
		try{
			while((line = br.readLine()) != null){
				try{
					cont++;
					obj = (DBObject) JSON.parse(line);
					if(obj != null)
						collection.insert(obj);
				}catch(DuplicateKeyException e){
					System.out.println("La pregunta con identificador "+obj.get("_id")+" ya se encuentra en la base de datos");
				}catch(JSONParseException e1){
					System.out.println("La linea "+cont+" se encuentra en un formato no valido");
				}
			}
		}catch(IOException e){
			System.out.println("Ha ocurrido un error al leer la l�nea "+cont);
		}
	}

	/**
	 * Metodo que limpia la coleccion que se le pase por parametro
	 * @param coll - Coleccion que se desea limpiar
	 * @throws MongoTimeoutException - No recibe respuesta del servidor
	 */
	public static void clearCollection(String coll)throws MongoTimeoutException{
		db.getCollection(coll).drop();
	}
	
	/**
	 * Metodo que devuelve los elementos de una coleccion
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
