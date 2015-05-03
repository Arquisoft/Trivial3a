import business.game.tablero.tableros.impl.TableroLineal;

import com.mongodb.util.JSON;

public class PruebaJS {

	public static void main(String[] args) {
		TableroLineal tl = new TableroLineal();
		
		String js = JSON.serialize(tl);
		
		System.out.println("Comienza la prueba de js");
		
		

	}

}
