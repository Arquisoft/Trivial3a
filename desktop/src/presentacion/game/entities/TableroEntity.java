package presentacion.game.entities;

import business.game.tablero.tableros.Tablero;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class TableroEntity extends Actor{
	/**
	 * La lÃ³gica del tablero
	 */
	private Tablero tablero;
	/**
	 * Casilla raíz para pintar
	 */
	private CasillaEntity casillaRaiz;
 	
	public TableroEntity(Tablero tablero){
		setTablero(tablero);
		generateCasillas();
	}
	
	/** Genera los dibujos de las casillas. Depende del tablero*/
	protected abstract void generateCasillas();
	
	@Override
	public void act(float delta) {
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		CasillaEntity c = casillaRaiz;
		do {
			c.draw(batch, parentAlpha);
		}while((c = c.getNextNodo()) != null);
	}
	
	//Getters and setters
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public CasillaEntity getCasillaRaiz() {
		return casillaRaiz;
	}

	public void setCasillaRaiz(CasillaEntity casillaRaiz) {
		this.casillaRaiz = casillaRaiz;
	}
	
}
