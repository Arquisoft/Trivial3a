package business.extractor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import business.parser.Parser;
import business.parser.ParserGIFT;
import business.parser.ParserQTI;
import business.preguntas.Pregunta;
import business.serializador.Serializador;
import business.serializador.json.JsonSerialImpl;

import persistencia.Insert;

public class Extractor {
	
	private Parser par;
	private Serializador ser;
	private String file;
	private Scanner s;
	private MenuExtractor ie;
	
	public void run(){
		ie = new MenuExtractor();
		s = new Scanner(System.in);
		setFile(s.nextLine());
		initialize(ie.getElapsed_time());
	}
	
	public void initialize(int time){				 
		try {
			do{
				setParser();
				HashMap<String, Pregunta> preguntasFinal = par.getPregunta();
				JsonSerialImpl j = new JsonSerialImpl();
				
				j.createFile(preguntasFinal, "Salida.JSON");
				
				if(ie.getAutomatizado() || ie.handleConnection())
					new Insert("Salida.JSON");
				try {
				    Thread.sleep(time);                 
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}while(time != 1);
		} catch (FileNotFoundException e) {
			System.err.println("No existe el archivo.");
		} catch (IOException e) {
			System.err.println("No se ha podido realizar la operacion.");
		}

	}
	
		
	public Parser getPar() {
		return par;
	}
	
	public void setParser() throws IOException{
		if(file.toUpperCase().endsWith(".GIFT"))
			par = new ParserGIFT(file);
		else if(file.toUpperCase().endsWith(".XML"))
			par = new ParserQTI(file);
		else
			throw new IOException();
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
