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
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class ScreenJuego implements Screen {
	/** El dibujo del tablero */
	private TableroEntity tablero;
	/** La lógica del juego */
	private JuegoEnTableroLineal juego;
	/** Una referencia a los jugadores */
	private List<Jugador> jugadores;
	
	private Stage stage;

	private Image bg;

	private Table tableUsuarios;
	private Image bgUsuarios;
	private Table tablePregunta;
	private Image bgPregunta;
	private Table tableTablero;
	private Image bgTablero;

	private Button moveLeft;
	private Button moveUp;
	private Button moveRight;
	private Button moveDown;
	private Button dice;
	
	private Label question;
	private Label diceResult;
	private TextButton answer1;
	private TextButton answer2;
	private TextButton answer3;
	private TextButton answer4;

	public ScreenJuego(JuegoEnTableroLineal juego, List<Jugador> jugadores,
			TableroLinealEntity tablero) {
		setTablero(tablero);
		setJugadores(jugadores);
		setJuego(juego);
	}

	@Override
	public void show() {
		stage = new Stage();
		stage.setViewport(new ScalingViewport(Scaling.fit, Gdx.graphics
				.getWidth(), Gdx.graphics.getHeight(), stage.getCamera()));
		stage.getViewport().update(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.input.setInputProcessor(stage);

		bg = new Image(new Texture(
				new FileHandle("assets/textures/game/bg.jpg")));
		bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		bg.setPosition(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2, Align.center);
		stage.addActor(bg);

		bgUsuarios = new Image(new Texture(new FileHandle(
				"assets/textures/game/bgUsuario.png")));
		bgUsuarios.setSize(0.2f * Gdx.graphics.getWidth(),
				0.8f * Gdx.graphics.getHeight());
		bgUsuarios.setPosition(0, Gdx.graphics.getHeight(), Align.topLeft);
		stage.addActor(bgUsuarios);

		bgPregunta = new Image(new Texture(new FileHandle(
				"assets/textures/game/bgPregunta.png")));
		bgPregunta.setSize(1f * Gdx.graphics.getWidth(),
				0.2f * Gdx.graphics.getHeight());
		bgPregunta.setPosition(0, 0, Align.bottomLeft);
		stage.addActor(bgPregunta);

		bgTablero = new Image(new Texture(new FileHandle(
				"assets/textures/game/bgTablero.png")));
		bgTablero.setSize(0.8f * Gdx.graphics.getWidth(),
				0.8f * Gdx.graphics.getHeight());
		bgTablero.setPosition(0, 0, Align.right);
		stage.addActor(bgTablero);

		tableUsuarios = new Table();
		tableUsuarios.setFillParent(false);
		tableUsuarios.setSize(0.2f * Gdx.graphics.getWidth(),
				0.8f * Gdx.graphics.getHeight());
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
		generatePreguntasTable();
		generateTablero();
		start();
	}

	/**
	 * Genera el contenido del menú de la izquierda (Listas de jugadores con
	 * sus quesitos, y botón menú)
	 */
	private void generateUsersTable() {
		TextButton btMenu = new TextButton(
				AssetsManager.LOCALIZATION.get("btMenu"), AssetsManager.skin,
				"default");
		btMenu.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.setScreen(new ScreenInicio());
				// TODO Quizás mostrar aquí un menú con opciones si da
				// tiempo.
			}
		});
		float width = Gdx.graphics.getWidth() * 0.2f; 
		float height = Gdx.graphics.getHeight() * 0.1f; ;
		btMenu.setSize(width, height);
		btMenu.setPosition(0, Gdx.graphics.getHeight() - height);

		Label label;
		float lbHeight = (0.8f * Gdx.graphics.getHeight() - height)/12;
		Jugador j;
		for (int i=0; i<jugadores.size(); i++) {
			j = jugadores.get(i);
			label = new Label(j.getUsuario().getLogin(), AssetsManager.skin);
			label.setBounds(0, (Gdx.graphics.getHeight() - height*1.5f - lbHeight*(i+1)), width, lbHeight);
			label.setColor(j.getColor().getColorLibgdx());
			label.setAlignment(Align.center, Align.center);
			stage.addActor(label);
			//tableUsuarios.add(label);
		}

		stage.addActor(btMenu);

		tableUsuarios.setClip(true);
	}
	/**
	 * Comienza el juego
	 */
	private void start(){
		question.setText("");
		answer1.setDisabled(true);answer1.setText("");
		answer2.setDisabled(true);answer2.setText("");
		answer3.setDisabled(true);answer3.setText("");
		answer4.setDisabled(true);answer4.setText("");
		moveLeft.setDisabled(true);
		moveRight.setDisabled(true);
		moveUp.setDisabled(true);
		moveDown.setDisabled(true);
	}
	/**
	 * Genera la sección de las preguntas (Su label y botones) y los de moverse y dado
	 */
	private void generatePreguntasTable() {
		moveLeft = new TextButton("<", AssetsManager.skin);
		moveRight = new TextButton(">", AssetsManager.skin);
		moveUp = new TextButton("", AssetsManager.skin);
		moveDown = new TextButton("", AssetsManager.skin);
		dice = new TextButton("+", AssetsManager.skin);
		diceResult = new Label("", AssetsManager.skin);
		
		//Moverse + dado
		float width = 0.2f * 0.33333f * Gdx.graphics.getWidth();
		float height = 0.2f * 0.5f * Gdx.graphics.getHeight();
		moveLeft.setBounds(0, 0, width, height);
		moveLeft.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!moveLeft.isDisabled()){
					juego.jugarIzquierda();
					question.setText(juego.getTextoPregunta());
					answer1.setText(juego.getRespuestasMezcladas().get(0));
					answer2.setText(juego.getRespuestasMezcladas().get(1));
					answer3.setText(juego.getRespuestasMezcladas().get(2));
					answer4.setText(juego.getRespuestasMezcladas().get(3));
				}
			}
		});
		stage.addActor(moveLeft);

		moveDown.setBounds(width, 0, width, height);
		stage.addActor(moveDown);

		moveRight.setBounds(width*2, 0, width, height);
		stage.addActor(moveRight);
		moveRight.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!moveRight.isDisabled()){
					juego.jugarDerecha();
					question.setText(juego.getTextoPregunta());
					answer1.setText(juego.getRespuestasMezcladas().get(0));
					answer2.setText(juego.getRespuestasMezcladas().get(1));
					answer3.setText(juego.getRespuestasMezcladas().get(2));
					answer4.setText(juego.getRespuestasMezcladas().get(3));
				}
			}
		});

		moveUp.setBounds(width, height, width, height);
		stage.addActor(moveUp);

		dice.setBounds(width*2, height, width, height);
		stage.addActor(dice);
		dice.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!dice.isDisabled()){
					juego.lanzarDado();
					dice.setDisabled(true);
					moveLeft.setDisabled(false);
					moveRight.setDisabled(false);
					diceResult.setText(String.valueOf(juego.getValorDado()));
					moveRight.setDisabled(false);
					moveLeft.setDisabled(false);
				}
			}
		});
		
		diceResult.setBounds(0, height, width, height);
		diceResult.setAlignment(Align.center);
		stage.addActor(diceResult);
		
		//Preguntas y respuestas
		float btSpacing = 0.8f * (0.05f*4/3) * Gdx.graphics.getWidth(); 
		float btWidth = 0.8f * 0.2f * Gdx.graphics.getWidth(); 
		answer1 = new TextButton("Respuesta 1", AssetsManager.skin);
		answer1.setBounds(width*3, 0, btWidth, height);
		answer1.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!answer1.isDisabled()){
					juego.responderAsociadoBoton(0);
				}
			}
		});
		answer2 = new TextButton("Respuesta 2", AssetsManager.skin);
		answer2.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!answer2.isDisabled()){
					juego.responderAsociadoBoton(0);
				}
			}
		});
		answer2.setBounds(width*3 + btSpacing + btWidth, 0, btWidth, height);
		answer3 = new TextButton("Respuesta 3", AssetsManager.skin);
		answer3.setBounds(width*3 + btSpacing*2 + btWidth*2, 0, btWidth, height);
		answer3.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!answer3.isDisabled()){
					juego.responderAsociadoBoton(2);
				}
			}
		});
		answer4 = new TextButton("Respuesta 4", AssetsManager.skin);
		answer4.setBounds(width*3 + btSpacing*3 + btWidth * 3, 0, btWidth, height);
		answer4.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!answer4.isDisabled()){
					juego.responderAsociadoBoton(3);
				}
			}
		});
		stage.addActor(answer1);
		stage.addActor(answer2);
		stage.addActor(answer3);
		stage.addActor(answer4);

		question = new Label("", AssetsManager.skin);
		question.setBounds(width*3, height, 0.8f*Gdx.graphics.getWidth(), height);
		question.setAlignment(Align.center);
		stage.addActor(question);
	}

	/**
	 * Genera el tablero en el que se va a jugar
	 */
	private void generateTablero() {
		stage.addActor(tablero);
		tablero.setWidth(0.8f*0.8f*Gdx.graphics.getWidth());
		tablero.setHeight(0.15f*Gdx.graphics.getHeight());
		tablero.setPosition(0.2f*Gdx.graphics.getWidth() + 0.8f*0.1f*Gdx.graphics.getWidth(), 0.8f*Gdx.graphics.getHeight()/2 - tablero.getHeight()/2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		if (Gdx.input.isKeyPressed(Keys.B))
			stage.setDebugAll(true);
		if (Gdx.input.isKeyPressed(Keys.A))
			stage.setDebugAll(false);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// stage.getViewport().update(width, height);
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

	// GETTERS AND SETTERS

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
