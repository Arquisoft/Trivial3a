package presentacion.game.entities;

import business.game.tablero.nodos.Nodo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class CasillaEntity extends Actor{
	/** La imagen como la que se pintará la casilla*/
	private Image textura;
	/**El nodo al que hace referencia*/
	private Nodo nodo;
	/**El siguiente nodo a dibujar*/
	private CasillaEntity nextNodo;
	public CasillaEntity(Texture textura, Nodo nodo){
		setTextura(new Image(textura));
		this.textura.setColor(nodo.getColor().getColorLibgdx());
	}
	@Override
	public void draw(Batch batch, float parentAlpha){
		textura.draw(batch, parentAlpha);
	}
	public Image getTextura() {
		return textura;
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
