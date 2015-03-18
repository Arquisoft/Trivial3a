package business.extractor;

import java.util.Scanner;

public class MenuExtractor {
	private Scanner s;
	private boolean automatizado;
	private int elapsed_time = 1;
	
	/**
	 * Menu de inicio de la aplicacion
	 * 
	 */
	public MenuExtractor(){
		s = new Scanner(System.in);
		System.out.println("Bienvenido al asistente");
		System.out.println("Introduzca el numero con la operacion que desea realizar");
		System.out.println("0 - Salir de la aplicacion");
		System.out.println("1 - Comenzar con la lectura y subida de datos");
		System.out.println("2 - Automatizar la lectura y subida de datos");
		handleOptions(s.nextLine());
	}
	
	/**
	 * Metodo encargado de relacionar la opcion elegida con su accion
	 * 
	 * @param opc - Opcion elegida
	 */
	public void handleOptions(String opc){
		switch (opc){
			case "0" :  System.exit(0);
						break;
						
			case "1" :  System.out.println("Opcion 1 elegida - Comenzar con la lectura y subida de datos ");
						automatizado = false;
						System.out.println("Inserte la ruta del fichero.");
						break;
				
			case "2" :  System.out.println("Opcion 2 elegida - Automatizar la lectura y subida de datos");
						automatizado = true;
						System.out.println("¿Cada cuanto tiempo quiere que se realicen la lectura y subida? Introducir datos en segundos");
						handleTime();
						System.out.println("Inserte la ruta del fichero.");
						break;
			
			default :   System.out.println("Opcion incorrecta, vuelva a introducir los datos");
						handleOptions(s.nextLine());
						break;
		
		}
	}
	/**
	 * Metodo encargado guardar el tiempo introducido por el usuario
	 * 
	 */
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
	/**
	 * Metodo que permite al administrador continuar sus operaciones subiendo a la base de datos sus cambios.
	 * 
	 * @return true - S / false - No
	 */
	public boolean handleConnection(){
		System.out.println("El archivo ha sido traducido con exito. ¿Desea subir este archivo a la base de datos?");
		System.out.println("s/n");
		String op = null;
		do{
			if(op != null)
				System.out.println("Opcion incorrecta, vuelva a introducir los datos");
			op = s.next();
		}while(!op.equals("s") && !op.equals("n"));
		if(op.equals("s"))
			return true;
		return false;
		
	}
	/**
	 * Metodo que devuelve el atributo automatizado
	 * 
	 * @return automatizado
	 */
	public boolean getAutomatizado(){
		return automatizado;
	}
	
	/**
	 *  Metodo que devuelve el tiempo entre repeticiones aportado por el usuario
	 *  
	 * @return elapsed_time
	 */
	
	public int getElapsed_time(){
		return elapsed_time;
	}
}
