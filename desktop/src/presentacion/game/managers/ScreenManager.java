package presentacion.game.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ScreenManager {
	public static Screen currentScreen;
	
	/**
	 * Cambia la pantalla actual a la pasada en el parámetro
	 * @param screen
	 */
	public static void setScreen(Screen screen) {
		if (currentScreen != null)
			currentScreen.dispose();
		currentScreen = screen;
		((Game) Gdx.app.getApplicationListener()).setScreen(screen);
	}
	
	/**
	 * Devuelve la pantalla actual
	 * @return
	 */
	public static Screen getCurrentscreen() {
		return currentScreen;
	}
}
