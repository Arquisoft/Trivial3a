package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pregunta.Pregunta;

import sintactico.Parser;

import lexico.Lexico;


public class Main {

	public static void main(String args[]) throws IOException {
	    if (args.length<1) {
	        System.err.println("Necesito el archivo de entrada.");
	        return;
	    }
	        
		FileReader fr=null;
		try {
			fr=new FileReader(args[0]);
		} catch(IOException io) {
			System.err.println("El archivo "+args[0]+" no se ha podido abrir.");
			return;
		}
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		Lexico lexico = new Lexico(fr);
		Parser parser = new Parser(lexico);
		//parser.run();
		int token;
		while ((token=lexico.yylex())!=0) {
		    if(token==258){
		    	Pregunta preg = new Pregunta((String)parser.getYylval(),"","","","","");
		    	while ((token=lexico.yylex())!=125) {
		    		if(token==126){
		    			token=lexico.yylex();
		    			if(preg.getAnswer2().equals("")){
		    				preg.setAnswer2((String)parser.getYylval());
		    			}
		    			else if(preg.getAnswer3().equals("")){
		    				preg.setAnswer3((String)parser.getYylval());
		    			}
		    			else{
		    				preg.setAnswer4((String)parser.getYylval());
		    			}
		    		}
		    		else if(token == 61){
		    			token=lexico.yylex();
		    			preg.setAnswerTrue((String)parser.getYylval());
		    		}
		    		else if(token==259 && !((String)parser.getYylval()).equals(" ")){
		    			preg.setQuestion((String)parser.getYylval());	
		    		}
		    	}
		    	preguntas.add(preg);
		    }
		}
		int i =0;
		while(i <preguntas.size() ){
			System.out.println(((Pregunta)preguntas.get(i)).toString());
			i++;
		}
		    
	}

}
