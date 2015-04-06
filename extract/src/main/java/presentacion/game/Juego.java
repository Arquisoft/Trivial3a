package presentacion.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import es.uniovi.asw.trivial.views.managers.AssetsManager;

public class Juego implements Screen {
	public final static float BUTTON_W=0.3f*Gdx.graphics.getWidth();//Width
	public final static float BUTTON_H=0.1f*Gdx.graphics.getHeight();//Height
	public final static float BUTTON_S=0.05f*Gdx.graphics.getHeight();//Spacing
	
	private Stage stage;
	
	private Image bg;
	
	private Table tableUsuarios;
	private Image bgUsuarios;
	private Table tablePregunta;
	private Image bgPregunta;
	private Table tableTablero;
	private Image bgTablero;
	
	@Override
	public void show () {
		stage = new Stage();
		stage.setViewport(new ScalingViewport(Scaling.fit, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), stage.getCamera()));
		stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.input.setInputProcessor(stage);
		
		bg = new Image(new Texture(Gdx.files.internal("textures/game/bg.jpg")));
		bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		bg.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, Align.center);
		stage.addActor(bg);
		
		bgUsuarios = new Image(new Texture(Gdx.files.internal("textures/game/bgUsuario.png")));
		bgUsuarios.setSize(0.2f*Gdx.graphics.getWidth(), 0.8f*Gdx.graphics.getHeight());
		bgUsuarios.setPosition(0, Gdx.graphics.getHeight(), Align.topLeft);
		stage.addActor(bgUsuarios);
		
		bgPregunta= new Image(new Texture(Gdx.files.internal("textures/game/bgPregunta.png")));
		bgPregunta.setSize(1f*Gdx.graphics.getWidth(), 0.2f*Gdx.graphics.getHeight());
		bgPregunta.setPosition(0, 0, Align.bottomLeft);
		stage.addActor(bgPregunta);
		
		bgTablero = new Image(new Texture(Gdx.files.internal("textures/game/bgTablero.png")));
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
	}
	
	private void generateUsersTable(){
		TextButton btMenu = new TextButton(AssetsManager.LOCALIZATION.get("btMenu"), AssetsManager.skin , "default");		
		tableUsuarios.add(btMenu).height(0.05f*Gdx.graphics.getHeight()).row();
		
		Label j1 = new Label("Jugador 1", AssetsManager.skin);
		tableUsuarios.add(j1).height(50f).row();
		
		Label j2= new Label("Jugador 2", AssetsManager.skin);
		tableUsuarios.add(j2).height(50f).row();
		
		Label j3 = new Label("Jugador 3", AssetsManager.skin);
		tableUsuarios.add(j3).height(50f);
		
		tableUsuarios.setClip(true);
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.setDebugAll(true);
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
