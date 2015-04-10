package presentacion.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

public class AssetsManager {
	//LANGUAGES
		public static I18NBundle LOCALIZATION;
	//UI		
		public static Skin skin;
		public static TextureAtlas tonyAtlas;
		private static Preferences prefs = Gdx.app.getPreferences("Opciones");
		
		public static LabelStyle estilo = new LabelStyle();
	     
	//Private members
		private static BitmapFont defaultLabelStyle = new BitmapFont( new FileHandle("assets/font2.fnt"));
	/**
	 * M�todo para cargar a pi��n toda la configuraci�n de los assets (fuentes, sonidos, atlas, skins...)	
	 */
	 
	public static void initialize(){
		LOCALIZATION=I18NBundle.createBundle(new FileHandle("assets/i18n/localization"));	
		skin = new Skin(new FileHandle("assets/uiskin.json"));	
		
		estilo.font = defaultLabelStyle;
	}
	
	/**
	 * Pincha una canci�n como por ejemplo "El Taxi"
	 */
	public static void playMusic(Music m, boolean looping){
		m.play();
		m.setLooping(looping);
		//m.setVolume(prefs.getFloat(OptionsMenu.OPTIONS_MUSIC_VOLUME_STRING));
	}
	/**
	 * Pincha unos sonidos como por ejemplo alguien insult�ndome por poner "El Taxi" en horas lectivas.
	 */
	public static void playSound(Sound s, boolean looping){
		long id = s.play();
		s.setLooping(id, looping);
		//s.setVolume(id, prefs.getFloat(OptionsMenu.OPTIONS_MUSIC_VOLUME_STRING));
	}
}
