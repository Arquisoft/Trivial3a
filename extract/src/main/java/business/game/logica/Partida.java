package business.game.logica;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import business.game.acciones.util.ColorEnum;

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

	public static void eliminarEntrada(JList<String> listaJugadores,DefaultListModel<String> modeloLista){
		String nombre_usuario = listaJugadores.getSelectedValue();
		for(Entry<ColorEnum, Usuario> user: Partida.getPartida().entrySet()){
			if(user.getValue().getLogin().equals(nombre_usuario)){
				partida.remove(user.getKey());
				modeloLista.removeElementAt(listaJugadores.getSelectedIndex());
			}
		}
	}
}
