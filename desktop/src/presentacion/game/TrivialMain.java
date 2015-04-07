package presentacion.game;
import presentacion.game.managers.AssetsManager;
import presentacion.game.managers.ScreenManager;

import com.badlogic.gdx.Game;


public class TrivialMain extends Game {
	//Static Variables
	public static final String title="Tony: Bicho Bola";
	public static final Boolean DEBUG=true;
	public static final float HEIGHT=720,WIDTH=1280;
	//End Static Variables
	
	@Override
	public void create () {
		AssetsManager.initialize();
		ScreenManager.setScreen(new ScreenInicio());
	}
}
