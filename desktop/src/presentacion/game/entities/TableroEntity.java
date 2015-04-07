package presentacion.game.entities;

import business.game.tablero.tableros.Tablero;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class TableroEntity extends Actor{
	/**
	 * La lógica del tablero
	 */
	private Tablero tablero;	
	
	/** Casilla raíz en la que se empieza. Debería ser la misma que la de nodo raíz del tablero. No me responsabilizo si alguien hace cosas raras.*/
	//private CasillaEntity casillaRaiz;
	//private CasillaEntity casillaAux;
	//private ContenedorCasillasEntity casillas;
 	
	public TableroEntity(Tablero tablero){
		setTablero(tablero);
	}
	
	@Override
	public void act(float delta) {

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		//tablero.
	}
	
	//Getters and setters
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
