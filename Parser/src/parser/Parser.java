package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import preguntas.Pregunta;

public class Parser {
	
	private  String file;
	
	public Parser(String string)  {
			this.file = string;
	}

	public  ArrayList<Pregunta> getPregunta() throws IOException{
		
		ArrayList<Pregunta> preguntas = new ArrayList<>(); //preguntas
		
		//preparacion de los parametros de lectura
		File archivo = new File(file);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		//Creacion de parametros para las preguntas
		String ID="";
		String pregunta ="";
		ArrayList<String> respuestas = new ArrayList<>();
		String respuestaCorrecta="";
		
		String linea;
        while((linea=br.readLine())!=null){
        	
           //System.out.println(linea); //Solo para Debug
           
           if(linea.contains(":"))//ID de la pregunta
        	   ID = linea.split("::")[1];
           
           else if(linea.contains("{"))//Texto de la pregunta
        	   pregunta = linea.replace('{', ' ');
           
           else if(linea.contains("~")){ //respuesta Incorrecta (entrara 3 veces)
        	   respuestas.add(linea.split("~")[1]);
        	   if(respuestas.size()==3 && respuestaCorrecta != ""){
        		   preguntas.add(new Pregunta(ID,pregunta,respuestas,respuestaCorrecta));
        		   ID="";pregunta="";respuestaCorrecta="";respuestas = new ArrayList<>();
        	   }
           }
           
           else if(linea.contains("=")){ //respuesta correcta
        	   respuestaCorrecta = linea.split("=")[1];
        	   if(respuestas.size()==3){
        		   preguntas.add(new Pregunta(ID,pregunta,respuestas,respuestaCorrecta));
        		   ID="";pregunta="";respuestaCorrecta="";respuestas = new ArrayList<>();
        	   }
           }
           
        }
        br.close();
		return preguntas;
	}
}
