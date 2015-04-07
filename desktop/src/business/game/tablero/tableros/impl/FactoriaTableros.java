package business.game.tablero.tableros.impl;

import business.game.tablero.tableros.ServiceFactoriaTableros;
import business.game.tablero.tableros.Tablero;

public class FactoriaTableros implements ServiceFactoriaTableros {

	@Override
	public Tablero getTableroCircular(int tam) {
		return new TableroCircular(tam);
	}

	@Override
	public Tablero getTableroLineal(int tam) {
		return new TableroLineal(tam);
	}

	@Override
	public Tablero getTableroRueda(int tam) {
		return new TableroRueda(tam);
	}

	

}
