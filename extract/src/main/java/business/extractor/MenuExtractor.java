package business.extractor;

import java.util.Scanner;

public class MenuExtractor {
	private Scanner s;
	private boolean automatizado;
	private int elapsed_time = 1;
	
	/**
	 * Men� de inicio de la aplicaci�n
	 * 
	 */
	public MenuExtractor(){
		s = new Scanner(System.in);
		System.out.println("Bienvenido al asistente");
		System.out.println("Introduzca el n�mero con la operaci�n que desea realizar");
		System.out.println("0 - Salir de la aplicaci�n");
		System.out.println("1 - Comenzar con la lectura y subida de datos");
		System.out.println("2 - Automatizar la lectura y subida de datos");
		handleOptions(s.nextLine());
	}
	
	/**
	 * M�todo encargado de relacionar la opci�n elegida con su acci�n
	 * 
	 * @param opc - Opci�n elegida
	 */
	public void handleOptions(String opc){
		switch (opc){
			case "0" :  System.exit(0);
						break;
						
			case "1" :  System.out.println("Opci�n 1 elegida - Comenzar con la lectura y subida de datos ");
						automatizado = false;
						System.out.println("Inserte la ruta del fichero.");
						break;
				
			case "2" :  System.out.println("Opci�n 2 elegida - Automatizar la lectura y subida de datos");
						automatizado = true;
						System.out.println("�Cada cu�nto tiempo quiere que se realicen la lectura y subida? Introducir datos en segundos");
						handleTime();
						System.out.println("Inserte la ruta del fichero.");
						break;
			
			default :   System.out.println("Opci�n incorrecta, vuelva a introducir los datos");
						handleOptions(s.nextLine());
						break;
		
		}
	}
	/**
	 * M�todo encargado guardar el tiempo introducido por el usuario
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
	 * M�todo que permite al administrador continuar sus operaciones subiendo a la base de datos sus cambios.
	 * 
	 * @return true - S� / false - No
	 */
	public boolean handleConnection(){
		System.out.println("El archivo ha sido traducido con �xito. �Desea subir este archivo a la base de datos?");
		System.out.println("s/n");
		String op = null;
		do{
			if(op != null)
				System.out.println("Opci�n incorrecta, vuelva a introducir los datos");
			op = s.next();
		}while(!op.equals("s") && !op.equals("n"));
		if(op.equals("s"))
			return true;
		return false;
		
	}
	/**
	 * M�todo que devuelve el atributo automatizado
	 * 
	 * @return automatizado
	 */
	public boolean getAutomatizado(){
		return automatizado;
	}
	
	/**
	 *  M�todo que devuelve el tiempo entre repeticiones aportado por el usuario
	 *  
	 * @return elapsed_time
	 */
	
	public int getElapsed_time(){
		return elapsed_time;
	}
}
