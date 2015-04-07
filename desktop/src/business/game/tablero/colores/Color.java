package business.game.tablero.colores;

import modelo.preguntas.Pregunta;

//los colores de las respectivas preguntas
//estï¿½ hecho con implementaciï¿½n de muchas clases 
//por si se queire hacer laprï¿½ctica persistente que 
//sea mï¿½s facil en mi opiniï¿½n gestionar los accesos a una 
//base de datos en funciï¿½n de las categorï¿½as de la pregunta
public interface Color {
	public com.badlogic.gdx.graphics.Color getColorLibgdx();
	public Pregunta getPregunta();//TODO conexión a base de datos y sacar pregunta de cada categoría.
}
