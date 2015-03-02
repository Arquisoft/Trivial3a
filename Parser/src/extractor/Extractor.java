package extractor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import jsonSerializer.Serializador;
import jsonSerializer.Impl.JsonSerialImpl;
import parser.Parser;
import parser.ParserGIFT;
import parser.ParserQTI;
import preguntas.Pregunta;

public class Extractor {
	
	private Parser par;
	private Serializador ser;
	private String file;
	



	public void run (){
		Parser p = null;
		JsonSerialImpl j = new JsonSerialImpl();
		
		if(file.toUpperCase().endsWith(".GIFT"))
			p = new ParserGIFT(file);
		else if(file.toUpperCase().endsWith(".XML"))
			p = new ParserQTI(file);
		 
		try {
			HashMap<String, Pregunta> preguntasFinal = p.getPregunta();
			
			j.createFile(preguntasFinal, "Salida.JSON");
		} catch (FileNotFoundException e) {
			System.err.println("No existe el archivo.");
		} catch (IOException e) {
			System.err.println("No se ha podido realizar la operación.");
		}
	}
	
	
	
	public Parser getPar() {
		return par;
	}
	
	
	
	public void setPar(Parser par) {
		this.par = par;
	}
	
	
	
	public Serializador getSer() {
		return ser;
	}
	
	
	
	public void setSer(Serializador ser) {
		this.ser = ser;
	}
	
	
	
	public String getFile() {
		return file;
	}
	
	
	
	public void setFile(String file) {
		this.file = file;
	}
}
