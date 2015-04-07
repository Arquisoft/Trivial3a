package presentacion.game;

import java.util.Map;

import business.game.login.Usuario;
import business.game.login.acciones.util.ColorEnum;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static Map<ColorEnum, Usuario> jugadores;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=768;
		config.width=1366;
		config.resizable=true;
		config.fullscreen=false;
		config.title="Trivial 3A";
		new LwjglApplication(new TrivialMain(), config);
	}
}
