package business.game.tablero.tableros.impl;

import business.game.tablero.tableros.ServiceFactoriaTableros;
import business.game.tablero.tableros.Tablero;

public class FactoriaTableros implements ServiceFactoriaTableros {

	@Override
	public Tablero getTableroCircular() {
		return new TableroCircular();
	}

	@Override
	public Tablero getTableroLineal() {
		return new TableroLineal();
	}

	@Override
	public Tablero getTableroRueda(int tam) {
		return new TableroRueda(tam);
	}

	

}
