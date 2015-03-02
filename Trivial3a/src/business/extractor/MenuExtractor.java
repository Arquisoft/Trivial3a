package business.extractor;

import java.util.Scanner;

public class MenuExtractor {
	private Scanner s;
	private boolean automatizado;
	private int elapsed_time = 1;
	
	
	public MenuExtractor(){
		s = new Scanner(System.in);
		System.out.println("Bienvenido al asistente");
		System.out.println("Introduzca el número con la operación que desea realizar");
		System.out.println("0 - Salir de la aplicación");
		System.out.println("1 - Comenzar con la lectura y subida de datos");
		System.out.println("2 - Automatizar la lectura y subida de datos");
		handleOptions(s.nextLine());
	}
	
	public void handleOptions(String opc){
		switch (opc){
			case "0" :  System.exit(0);
						break;
						
			case "1" :  System.out.println("Opción 1 elegida - Comenzar con la lectura y subida de datos ");
						automatizado = false;
						System.out.println("Inserte la ruta del fichero.");
						break;
				
			case "2" :  System.out.println("Opción 2 elegida - Automatizar la lectura y subida de datos");
						automatizado = true;
						System.out.println("¿Cada cuánto tiempo quiere que se realicen la lectura y subida? Introducir datos en segundos");
						handleTime();
						System.out.println("Inserte la ruta del fichero.");
						break;
			
			default :   System.out.println("Opción incorrecta, vuelva a introducir los datos");
						handleOptions(s.nextLine());
						break;
		
		}
	}
	
	public void handleTime(){
		try{
			elapsed_time = Integer.parseInt(s.nextLine())*1000;
			if(elapsed_time <= 10*1000)
				throw new NumberFormatException();
		}catch(NumberFormatException e){
			System.out.println("El tiempo elegido no es correcto o es menor a 10 segundos, vuelva a introducir los datos");
			handleTime();
		}
	}
	public boolean handleConnection(){
		System.out.println("El archivo ha sido traducido con éxito. ¿Desea subir este archivo a la base de datos?");
		System.out.println("s/n");
		String op;
		do{
			op = s.next();
		}while(!op.equals("s") && !op.equals("n"));
		if(op.equals("s"))
			return true;
		return false;
		
	}
	
	public boolean getAutomatizado(){
		return automatizado;
	}
	
	public int getElapsed_time(){
		return elapsed_time;
	}
}
