package es.uniovi.asw.trivial.views.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ScreenManager {
	public static Screen currentScreen;

	public static void setScreen(Screen screen) {
		if (currentScreen != null)
			currentScreen.dispose();
		currentScreen = screen;
		((Game) Gdx.app.getApplicationListener()).setScreen(screen);
	}

	public static Screen getCurrentscreen() {
		return currentScreen;
	}
}
