package game.logica;

import game.acciones.util.Color;

import java.util.HashMap;
import java.util.Map;

public class Partida {

	private static Map<Color, Usuario> partida =  new HashMap<Color, Usuario>();


	static public Map<Color, Usuario> getPartida() {
		return partida;
	}

	public void setPartida(Map<Color, Usuario> partida) {
		Partida.partida = partida;
	}
	
	static public void addUsuario(Color color, Usuario u){
		Partida.partida.put(color, u);
	}

}
