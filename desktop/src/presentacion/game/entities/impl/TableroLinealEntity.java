package presentacion.game.entities.impl;

import presentacion.game.entities.TableroEntity;
import business.game.tablero.nodos.Nodo;
import business.game.tablero.tableros.Tablero;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class TableroLinealEntity extends TableroEntity{
	
	private int casillas;
	public TableroLinealEntity(Tablero tablero) {
		super(tablero);
	}

	@Override
	protected void generateCasillas() {
		setCasillaRaiz(new CasillaEntity(new Texture(new FileHandle("assets/textures/game/casillaDefault.jpg")), getTablero().getReferencia()));
		CasillaEntity aux = getCasillaRaiz();
		Nodo auxNodo = getTablero().getReferencia();
		casillas = 1;
		while((auxNodo = auxNodo.getSiguiente())!=null){
			aux.setNextNodo(new CasillaEntity(new Texture(new FileHandle("assets/textures/game/casillaDefault.jpg")), auxNodo));
			aux = aux.getNextNodo();
			casillas++;
		}
	}
	@Override
	public void setPosition(float x, float y){
		super.setPosition(x,y);
		CasillaEntity c = getCasillaRaiz();
		float width = c.getWidth();
		int i = 0;
		do {
			c.setPosition(x + width*i, y);
			i++;
		}while((c = c.getNextNodo()) != null);
	}
	
	@Override
	public void setWidth(float width){
		super.setWidth(width);
		CasillaEntity c = getCasillaRaiz();
		do {
			c.setWidth(width/casillas);
		}while((c = c.getNextNodo()) != null);
		System.out.println("Casillas:" + casillas + " Width:" + width);
	}
	@Override
	public void setHeight(float height){
		super.setHeight(height);
		CasillaEntity c = getCasillaRaiz();
		do {
			c.setHeight(height);
		}while((c = c.getNextNodo()) != null);
	}

	@Override
	public void mueveFicha(int jugador) {
		// TODO Auto-generated method stub
		
	}
}
