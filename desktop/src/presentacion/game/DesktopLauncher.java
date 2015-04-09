package presentacion.game;

import java.util.HashMap;
import java.util.Map;

import modelo.usuario.Usuario;
import business.game.tablero.colores.Azul;
import business.game.tablero.colores.Color;
import business.game.tablero.colores.Rojo;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static Map<Color, Usuario> jugadores;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.height=768;
//		config.width=1366;
		config.resizable=true;
		config.fullscreen=false;
		config.title="Trivial 3A";
		
		jugadores = new HashMap<Color, Usuario>();
		jugadores.put(new Azul(), new Usuario("P3n3", "", "", "", "", 0, 0, 0, 0));
		jugadores.put(new Rojo(), new Usuario("Vagina", "", "", "", "", 0, 0, 0, 0));
		new LwjglApplication(new TrivialMain(), config);
	}
}
