package presentacion.game.entities.impl;

import presentacion.game.entities.CasillaEntity;
import presentacion.game.entities.TableroEntity;
import business.game.tablero.nodos.Nodo;
import business.game.tablero.tableros.Tablero;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class TableroLinealEntity extends TableroEntity{

	public TableroLinealEntity(Tablero tablero) {
		super(tablero);
	}

	@Override
	protected void generateCasillas() {
		setCasillaRaiz(new CasillaEntity(new Texture(new FileHandle("assets/textures/game/casillaDefault.jpg")), getTablero().getReferencia()));
		CasillaEntity aux = getCasillaRaiz();
		Nodo auxNodo = getTablero().getReferencia();
		while((auxNodo = auxNodo.getSiguiente())!=null){
			aux.setNextNodo(new CasillaEntity(new Texture(new FileHandle("assets/textures/game/casillaDefault.jpg")), auxNodo));
			aux = aux.getNextNodo();
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
	public float getWidth(){
		CasillaEntity c = getCasillaRaiz();
		float width = c.getWidth();
		int finalWidth = 0;
		do {
			finalWidth+=width;
		}while((c = c.getNextNodo()) != null);
		return finalWidth;
	}
}
