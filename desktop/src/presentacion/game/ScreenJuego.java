package presentacion.game;

import java.util.List;

import presentacion.game.entities.TableroEntity;
import presentacion.game.entities.impl.TableroLinealEntity;
import presentacion.game.managers.AssetsManager;
import presentacion.game.managers.ScreenManager;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class ScreenJuego implements Screen {
	public final static float BUTTON_W=0.2f*Gdx.graphics.getWidth();//Width
	public final static float BUTTON_H=0.1f*Gdx.graphics.getHeight();//Height
	public final static float BUTTON_S=0.05f*Gdx.graphics.getHeight();//Spacing
	
	private TableroEntity tablero; /**El dibujo del tablero */
	private JuegoEnTableroLineal juego; /**La lógica del juego*/
	private List<Jugador> jugadores; /** Una referencia a los jugadores */
	
	private Stage stage;
	
	private Image bg;
	
	private Table tableUsuarios;
	private Image bgUsuarios;
	private Table tablePregunta;
	private Image bgPregunta;
	private Table tableTablero;
	private Image bgTablero;
	 
	public ScreenJuego(JuegoEnTableroLineal juego, List<Jugador> jugadores, TableroLinealEntity tablero) {
		setTablero(tablero);
		setJugadores(jugadores);
		setJuego(juego);
	}

	@Override
	public void show () {
		stage = new Stage();
		stage.setViewport(new ScalingViewport(Scaling.fit, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), stage.getCamera()));
		stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.input.setInputProcessor(stage);
		
		bg = new Image(new Texture(new FileHandle("assets/textures/game/bg.jpg")));
		bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		bg.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, Align.center);
		stage.addActor(bg);
		
		bgUsuarios = new Image(new Texture(new FileHandle("assets/textures/game/bgUsuario.png")));
		bgUsuarios.setSize(0.2f*Gdx.graphics.getWidth(), 0.8f*Gdx.graphics.getHeight());
		bgUsuarios.setPosition(0, Gdx.graphics.getHeight(), Align.topLeft);
		stage.addActor(bgUsuarios);
		
		bgPregunta= new Image(new Texture(new FileHandle("assets/textures/game/bgPregunta.png")));
		bgPregunta.setSize(1f*Gdx.graphics.getWidth(), 0.2f*Gdx.graphics.getHeight());
		bgPregunta.setPosition(0, 0, Align.bottomLeft);
		stage.addActor(bgPregunta);
		
		bgTablero = new Image(new Texture(new FileHandle("assets/textures/game/bgTablero.png")));
		bgTablero.setSize(0.8f*Gdx.graphics.getWidth(), 0.8f*Gdx.graphics.getHeight());
		bgTablero.setPosition(0, 0, Align.right);
		stage.addActor(bgTablero);
		
		tableUsuarios = new Table();
		tableUsuarios.setFillParent(false);
		tableUsuarios.setSize(0.2f*Gdx.graphics.getWidth(), 0.8f*Gdx.graphics.getHeight());
		tableUsuarios.setPosition(0, Gdx.graphics.getHeight(), Align.topLeft);
		stage.addActor(tableUsuarios);

		tablePregunta = new Table();
		tablePregunta.setFillParent(false);
		tablePregunta.setPosition(50, 50, Align.bottomLeft);
		stage.addActor(tablePregunta);
			
		tableTablero = new Table();
		tableTablero.setFillParent(false);
		tableTablero.setPosition(50, 50, Align.topRight);
		stage.addActor(tableTablero);
		
		generateUsersTable();
		generatePlayButtons();
		generatePreguntasTable();
		generateTablero();
	}
	/**
	 * Genera el contenido del menú de la izquierda (Listas de jugadores con sus quesitos, y botón menú)
	 */
	private void generateUsersTable(){
		TextButton btMenu = new TextButton(AssetsManager.LOCALIZATION.get("btMenu"), AssetsManager.skin , "default");
		btMenu.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				ScreenManager.setScreen(new ScreenInicio());
				//TODO Quizás mostrar aquí un menú con opciones si da tiempo.
			}
		});
		btMenu.setSize(BUTTON_W, BUTTON_H);
		btMenu.setPosition(0, Gdx.graphics.getHeight() - BUTTON_H);
		
		
		Label label;
		for(Jugador j: jugadores){
			label = new Label(j.getUsuario().getLogin(), AssetsManager.skin);
			tableUsuarios.add(label);
		}
		
		stage.addActor(btMenu);
		

		tableUsuarios.setClip(true);
	}
	/**
	 * Genera los botones de moverse y tirar dado
	 */
	private void generatePlayButtons(){
	
	}
	/**
	 * Genera la sección de las preguntas (Su label y botones)
	 */
	private void generatePreguntasTable(){
		
	}
	/**
	 * Genera el tablero en el que se va a jugar
	 */
	private void generateTablero(){
		
	}
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		if(Gdx.input.isKeyPressed(Keys.B))
			stage.setDebugAll(true);
		if(Gdx.input.isKeyPressed(Keys.A))
			stage.setDebugAll(false);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		//stage.getViewport().update(width, height);
		stage.getViewport().update(width, height, true);
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
	//GETTERS AND SETTERS

	public TableroEntity getTablero() {
		return tablero;
	}

	public void setTablero(TableroEntity tablero) {
		this.tablero = tablero;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public JuegoEnTableroLineal getJuego() {
		return juego;
	}

	public void setJuego(JuegoEnTableroLineal juego) {
		this.juego = juego;
	}
	
	
}
