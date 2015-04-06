package business.game.tablero.tableros;

public interface ServiceFactoriaTableros{

	Tablero getTableroCircular(int tam);
	
	Tablero getTableroLineal(int tam);
	
	Tablero getTableroRueda(int tam);
	
	
}
