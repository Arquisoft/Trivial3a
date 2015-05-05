package business.game.tablero.util;

import business.game.tablero.colores.Amarillo;
import business.game.tablero.colores.Azul;
import business.game.tablero.colores.Color;
import business.game.tablero.colores.Incoloro;
import business.game.tablero.colores.Morado;
import business.game.tablero.colores.Naranja;
import business.game.tablero.colores.Rojo;
import business.game.tablero.colores.Verde;

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
		System.out.println(color);
		switch (color) {
		case "Amarillo":
			return new Amarillo();
		case "Azul":
			return new Azul();
		case "Incoloro":
			return new Incoloro();
		case "Morado":
			return new Morado();
		case "Naranja":
			return new Naranja();
		case "Rojo":
			return new Rojo();
		case "Verde":
			return new Verde();
		}

		return null;
	}
}
