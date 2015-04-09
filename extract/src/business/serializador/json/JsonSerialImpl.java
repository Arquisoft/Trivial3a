package business.serializador.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


import business.preguntas.Pregunta;
import business.serializador.Serializador;

import com.google.gson.Gson;

public class JsonSerialImpl implements Serializador {

	Gson gson = new Gson(); //Se inicializa el serializador
	
	@Override
	public void createFile(HashMap<String, Pregunta> preguntas, String localizacion) {
		

		try {
			FileWriter writer = new FileWriter(localizacion);
			for (Pregunta p : preguntas.values()) {
				String json = gson.toJson(p);
				writer.write(json+"\n");
			}

			writer.close();
			
		} catch (IOException e) {
			System.err.println("No se ha podido crear el archivo.");
		}
	}
	

}
