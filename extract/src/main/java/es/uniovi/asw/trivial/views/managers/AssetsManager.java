package es.uniovi.asw.trivial.views.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.I18NBundle;

public class AssetsManager {
	//LANGUAGES
		public static I18NBundle LOCALIZATION;
	//UI		
		public static Skin skin;
		public static TextureAtlas tonyAtlas;
		
		private static Preferences prefs = Gdx.app.getPreferences("Opciones");
	//Sounds and music
		
	/*
	 * Método para cargar a piñón toda la configuración de los assets (fuentes, sonidos, atlas, skins...)	
	 */
	public static void initialize(){
		LOCALIZATION=I18NBundle.createBundle(Gdx.files.internal("i18n/localization"));	
		skin = new Skin(Gdx.files.internal("uiskin.json"));		
	}
	
	/*
	 * Pincha una canción como por ejemplo "El Taxi"
	 */
	public static void playMusic(Music m, boolean looping){
		m.play();
		m.setLooping(looping);
		//m.setVolume(prefs.getFloat(OptionsMenu.OPTIONS_MUSIC_VOLUME_STRING));
	}
	/*
	 * Pincha unos sonidos como por ejemplo alguien insultándome por poner "El Taxi" en horas lectivas.
	 */
	public static void playSound(Sound s, boolean looping){
		long id = s.play();
		s.setLooping(id, looping);
		//s.setVolume(id, prefs.getFloat(OptionsMenu.OPTIONS_MUSIC_VOLUME_STRING));
	}
}
