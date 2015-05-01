package business.game.tablero.colores;

import modelo.preguntas.Pregunta;

//los colores de las respectivas preguntas
//est� hecho con implementaci�n de muchas clases 
//por si se queire hacer lapr�ctica persistente que 
//sea m�s facil en mi opini�n gestionar los accesos a una 
//base de datos en funci�n de las categor�as de la pregunta
public interface Color {
	//public com.badlogic.gdx.graphics.Color getColorLibgdx();
	public Pregunta getPregunta();//TODO conexi�n a base de datos y sacar pregunta de cada categor�a.
}
