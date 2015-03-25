package game.logica;

import game.acciones.util.ColorEnum;

import java.util.HashMap;
import java.util.Map;

public class Partida {

	private static Map<ColorEnum, Usuario> partida =  new HashMap<ColorEnum, Usuario>();


	static public Map<ColorEnum, Usuario> getPartida() {
		return partida;
	}

	public void setPartida(Map<ColorEnum, Usuario> partida) {
		Partida.partida = partida;
	}
	
	static public void addUsuario(ColorEnum color, Usuario u){
		Partida.partida.put(color, u);
	}

}
