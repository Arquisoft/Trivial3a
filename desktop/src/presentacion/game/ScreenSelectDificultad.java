package presentacion.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import modelo.usuario.Usuario;
import presentacion.game.managers.AssetsManager;
import presentacion.game.managers.ScreenManager;
import business.game.tablero.JuegoEnTableroLineal;
import business.game.tablero.colores.Azul;
import business.game.tablero.colores.Color;
import business.game.tablero.colores.Rojo;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.tableros.Tablero;
import business.game.tablero.tableros.impl.TableroLineal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class ScreenSelectDificultad implements Screen {
	public final static float BUTTON_W=0.3f*Gdx.graphics.getWidth();//Width
	public final static float BUTTON_H=0.1f*Gdx.graphics.getHeight();//Height
	public final static float BUTTON_S=0.05f*Gdx.graphics.getHeight();//Spacing
	
	private final static Image background = new Image(new Texture(new FileHandle("assets/textures/menuBG.jpg")));
	private Stage stage;
	private Table table;
	
	@Override
	public void show () {
		//8======D💦
		//		    💦🙆
		stage = new Stage();
		stage.setViewport(new ScalingViewport(Scaling.fit, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), stage.getCamera()));
		stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.input.setInputProcessor(stage);
		
		background.setScaling(Scaling.fill);
		background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		background.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, Align.center);
		stage.addActor(background);
		
		table = new Table();
		table.setFillParent(false);
		table.setPosition(0.15f*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2, Align.center);
		stage.addActor(table);

		final TextButton btPequeno = new TextButton(AssetsManager.LOCALIZATION.get("btPequeno"), AssetsManager.skin, "default");
		table.add(btPequeno).padLeft(BUTTON_S).size(BUTTON_W, BUTTON_H).padBottom(BUTTON_S).row();
		btPequeno.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Tablero t = new TableroLineal();//Simulamos una partida pa probar y esas cosas, druida.
				Map<Color, Usuario> jugadores = new HashMap<Color, Usuario>(); //Simulamos unos jugadores
				jugadores.put(new Azul(), new Usuario("a", "a", "a", "a", "a",0,0,0,0));
				jugadores.put(new Rojo(), new Usuario("b", "b", "b", "b", "b",0,0,0,0));
				generateJugadores(t, jugadores);
				ScreenManager.setScreen(new ScreenJuego(null, null));
			}
		});
		final TextButton btMedio = new TextButton(AssetsManager.LOCALIZATION.get("btMedio"), AssetsManager.skin, "default");
		table.add(btMedio).padLeft(BUTTON_S).size(BUTTON_W, BUTTON_H).padBottom(BUTTON_S).row();
		btMedio.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				ScreenManager.setScreen(new ScreenSelectDificultad());
			}
		});
		final TextButton btGrande = new TextButton(AssetsManager.LOCALIZATION.get("btGrande"), AssetsManager.skin, "default");
		table.add(btGrande).padLeft(BUTTON_S).size(BUTTON_W, BUTTON_H).padBottom(BUTTON_S).row();
		btGrande.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				ScreenManager.setScreen(new ScreenSelectDificultad());
			}
		});
	}
	
	/**
	 * Transforma los usuarios de la base de datos a una lista de jugadores con sus colores
	 * @param t
	 * @param usuarios
	 * @return
	 */
	private List<Jugador> generateJugadores(Tablero tablero, Map<Color, Usuario> usuarios){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for(Color color: usuarios.keySet()){
			jugadores.add(new Jugador(tablero, usuarios.get(color), color));//
		}
		return jugadores;
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
