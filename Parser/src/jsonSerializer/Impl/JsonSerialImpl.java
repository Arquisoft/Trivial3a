package jsonSerializer.Impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import jsonSerializer.JsonSerial;
import preguntas.Pregunta;

import com.google.gson.Gson;

public class JsonSerialImpl implements JsonSerial {

	Gson gson = new Gson();
	@Override
	public void createFile(HashMap<String, Pregunta> preguntas, String localizacion) {
		
		String json = gson.toJson(preguntas);
		try {
			
			FileWriter writer = new FileWriter(localizacion);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
