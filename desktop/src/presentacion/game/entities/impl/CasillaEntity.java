package presentacion.game.entities.impl;

import business.game.tablero.nodos.Nodo;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class CasillaEntity extends Actor{
	/** La imagen como la que se pintarï¿½ la casilla*/
	private Image textura;
	/**El nodo al que hace referencia*/
	private Nodo nodo;
	/**El siguiente nodo a dibujar*/
	private CasillaEntity nextNodo;
	/**La ficha si es que la casilla tiene alguna*/
	private Image ficha;
	public CasillaEntity(Texture textura, Nodo nodo){
		setNodo(nodo);
		setTextura(new Image(textura));
		Color color = nodo.getColor().getColorLibgdx();
		this.textura.setColor(color);
	}
	@Override
	public void draw(Batch batch, float parentAlpha){
		textura.draw(batch, parentAlpha);
		if(ficha!=null)
			ficha.draw(batch, parentAlpha);
	}
	public Image getTextura() {
		return textura;
	}
	@Override
	public void setPosition(float x, float y){
		super.setPosition(x, y);
		textura.setPosition(x, y);
	}
	@Override
	public void setWidth(float width){
		 super.setWidth(width);
		 textura.setWidth(width);
		 if(ficha != null)
			 ficha.setWidth(width);
	}
	@Override
	public void setHeight(float height){
		super.setHeight(height);
		textura.setHeight(height);
	}
	/**
	 * Añade una ficha del color especificado a la casilla
	 * @param c
	 */
	public void setFicha(Color c){
		ficha = new Image(new Texture(new FileHandle("assets/textures/game/trivialToken.png")));
		ficha.setColor(c);
		ficha.setPosition(getTextura().getX() + (getTextura().getWidth() - ficha.getWidth())/2, getTextura().getY() + (getTextura().getHeight() - ficha.getHeight())/2);
	}
	/**
	 * Elimina la ficha de la casilla
	 */
	public void cleanFicha(){
		ficha = null;
	}
	public void setTextura(Image textura) {
		this.textura = textura;
	}
	public Nodo getNodo() {
		return nodo;
	}
	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}
	public CasillaEntity getNextNodo() {
		return nextNodo;
	}
	public void setNextNodo(CasillaEntity nextNodo) {
		this.nextNodo = nextNodo;
	}
	
	
}
