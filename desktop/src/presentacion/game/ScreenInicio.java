package presentacion.game;

import presentacion.game.managers.AssetsManager;
import presentacion.game.managers.ScreenManager;
import presentacion.login.impl.VentanaLogin;

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

public class ScreenInicio implements Screen {
	public final static float BUTTON_W=0.3f*Gdx.graphics.getWidth();//Width
	public final static float BUTTON_H=0.1f*Gdx.graphics.getHeight();//Height
	public final static float BUTTON_S=0.05f*Gdx.graphics.getHeight();//Spacing
	
	private final static Image background = new Image(new Texture(new FileHandle("assets/textures/menuBG.jpg")));
	private Stage stage;
	private Table table;
	
	@Override
	public void show () {
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
		table.setPosition(Gdx.graphics.getWidth()/2, 0.15f*Gdx.graphics.getHeight(), Align.center);
		stage.addActor(table);
		
		final TextButton btJugar = new TextButton(AssetsManager.LOCALIZATION.get("mainMenuPlay"), AssetsManager.skin, "default");
		table.add(btJugar).size(BUTTON_W, BUTTON_H).padRight(BUTTON_S);
		btJugar.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				ScreenManager.setScreen(new ScreenSelectDificultad());
			}
		});
		final TextButton btOpciones = new TextButton(AssetsManager.LOCALIZATION.get("mainMenuOptions"), AssetsManager.skin, "default");
		table.add(btOpciones).size(BUTTON_W, BUTTON_H).padRight(BUTTON_S);
		btOpciones.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				//TODO ScreenManager.setScreen(new ScreenOpciones);
			}
		});
		final TextButton btSalir = new TextButton(AssetsManager.LOCALIZATION.get("mainMenuExit"), AssetsManager.skin, "default");
		table.add(btSalir).size(BUTTON_W, BUTTON_H);
		btSalir.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
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
		stage.dispose();
		
	}
}
