package business.game.tablero.util.lectores;

import java.io.IOException;

import business.game.tablero.util.ContenedorDeNodos;

public interface LectorTipoTablero {
	public ContenedorDeNodos cargarTablero(String fichero) throws IOException;
}
