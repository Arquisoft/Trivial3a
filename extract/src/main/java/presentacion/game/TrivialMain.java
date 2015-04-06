package presentacion.game;
import com.badlogic.gdx.Game;

import es.uniovi.asw.trivial.views.managers.AssetsManager;
import es.uniovi.asw.trivial.views.managers.ScreenManager;


public class TrivialMain extends Game {
	//Static Variables
	public static final String title="Tony: Bicho Bola";
	public static final Boolean DEBUG=true;
	public static final float HEIGHT=720,WIDTH=1280;
	//End Static Variables
	
	@Override
	public void create () {
		AssetsManager.initialize();
		ScreenManager.setScreen(new Inicio());
	}
}
