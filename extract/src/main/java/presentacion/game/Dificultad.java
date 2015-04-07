package presentacion.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import es.uniovi.asw.trivial.views.managers.AssetsManager;
import es.uniovi.asw.trivial.views.managers.ScreenManager;

public class Dificultad implements Screen {
	public final static float BUTTON_W=0.3f*Gdx.graphics.getWidth();//Width
	public final static float BUTTON_H=0.1f*Gdx.graphics.getHeight();//Height
	public final static float BUTTON_S=0.05f*Gdx.graphics.getHeight();//Spacing
	
	private final static Image background = new Image(new Texture(Gdx.files.internal("textures/menuBG.jpg")));
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
		table.setPosition(0.15f*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2, Align.center);
		stage.addActor(table);
		
		final TextButton btPequeno = new TextButton(AssetsManager.LOCALIZATION.get("btPequeno"), AssetsManager.skin, "default");
		table.add(btPequeno).padLeft(BUTTON_S).size(BUTTON_W, BUTTON_H).padBottom(BUTTON_S).row();
		btPequeno.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.setScreen(new Juego());
			}
		});
		final TextButton btMedio = new TextButton(AssetsManager.LOCALIZATION.get("btMedio"), AssetsManager.skin, "default");
		table.add(btMedio).padLeft(BUTTON_S).size(BUTTON_W, BUTTON_H).padBottom(BUTTON_S).row();
		btMedio.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				ScreenManager.setScreen(new Dificultad());
			}
		});
		final TextButton btGrande = new TextButton(AssetsManager.LOCALIZATION.get("btGrande"), AssetsManager.skin, "default");
		table.add(btGrande).padLeft(BUTTON_S).size(BUTTON_W, BUTTON_H).padBottom(BUTTON_S).row();
		btGrande.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {	
				ScreenManager.setScreen(new Dificultad());
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
		// TODO Auto-generated method stub
		
	}

}