package business.game.login;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.usuario.Usuario;
import business.game.tablero.colores.Color;

public class Partida {

	private static Map<Color, Usuario> partida =  new HashMap<Color, Usuario>();

	public Partida(){}
	
	static public Map<Color, Usuario> getPartida() {
		return partida;
	}

	public void setPartida(Map<Color, Usuario> partida) {
		Partida.partida = partida;
	}
	
	static public void addUsuario(Color color, Usuario u){
		Partida.partida.put(color, u);
	}

	public static void eliminarEntrada(JList<String> listaJugadores,DefaultListModel<String> modeloLista){
		String nombre_usuario = listaJugadores.getSelectedValue();
		for(Entry<Color, Usuario> user: Partida.getPartida().entrySet()){
			if(user.getValue().getLogin().equals(nombre_usuario)){
				partida.remove(user.getKey());
				modeloLista.removeElementAt(listaJugadores.getSelectedIndex());
			}
		}
	}
}
