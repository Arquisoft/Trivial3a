package business.game.tablero.util;

import business.game.tablero.logic.colores.Amarillo;
import business.game.tablero.logic.colores.Azul;
import business.game.tablero.logic.colores.Color;
import business.game.tablero.logic.colores.Incoloro;
import business.game.tablero.logic.colores.Morado;
import business.game.tablero.logic.colores.Naranja;
import business.game.tablero.logic.colores.Rojo;
import business.game.tablero.logic.colores.Verde;

public class SelectorDeColores {
	// hecho singleton
	private static SelectorDeColores INSTACE = new SelectorDeColores();

	private SelectorDeColores() {
	}

	public static SelectorDeColores getIstance() {
		return INSTACE;
	}

	// le llega un String y lo convierte en el color que sea
	public Color getColor(String color) {
		switch (color) {
		case "amarillo":
			return new Amarillo();
		case "azul":
			return new Azul();
		case "incoloro":
			return new Incoloro();
		case "morado":
			return new Morado();
		case "naranja":
			return new Naranja();
		case "rojo":
			return new Rojo();
		case "verde":
			return new Verde();
		}

		return null;
	}
}
